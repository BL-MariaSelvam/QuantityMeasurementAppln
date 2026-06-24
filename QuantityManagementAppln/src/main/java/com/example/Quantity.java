package com.example;

import java.util.Objects;

public class Quantity<U extends Enum<U> & IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(
                roundToTwoDecimals(convertedValue),
                targetUnit);
    }

    // ==================================================
    // CENTRALIZED VALIDATION HELPER
    // ==================================================

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Other quantity cannot be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException(
                    "Quantities must belong to same category");
        }

        if (!Double.isFinite(value) ||
                !Double.isFinite(other.value)) {
            throw new IllegalArgumentException(
                    "Values must be finite");
        }

        if (targetUnitRequired && targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }
    }

    // ==================================================
    // CENTRALIZED ARITHMETIC HELPER
    // ==================================================

    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        unit.validateOperationSupport(
                operation.name());

        other.unit.validateOperationSupport(
                operation.name());

        double firstBase =
                unit.convertToBaseUnit(value);

        double secondBase =
                other.unit.convertToBaseUnit(other.value);

        return operation.compute(firstBase, secondBase);
    }

    // ==================================================
    // ADD
    // ==================================================

    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double baseResult =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.ADD);

        double convertedResult =
                targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(
                roundToTwoDecimals(convertedResult),
                targetUnit);
    }

    // ==================================================
    // SUBTRACT
    // ==================================================

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double baseResult =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double convertedResult =
                targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(
                roundToTwoDecimals(convertedResult),
                targetUnit);
    }

    // ==================================================
    // DIVIDE
    // ==================================================

    public double divide(Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false);

        return performBaseArithmetic(
                other,
                ArithmeticOperation.DIVIDE);
    }

    // ==================================================
    // EQUALS
    // ==================================================

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?> other)) {
            return false;
        }

        if (unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                ((IMeasurable) other.unit)
                        .convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase)
                < 0.0001;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(
                unit.convertToBaseUnit(value));
    }

    private double roundToTwoDecimals(
            double value) {

        return Math.round(value * 100.0)
                / 100.0;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}