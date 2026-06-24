package com.example;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 0.00001;

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
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

    // ===========================
    // EQUALITY
    // ===========================

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?> other)) {
            return false;
        }

        if (!unit.getClass().equals(other.unit.getClass())) {
            return false;
        }

        double thisBaseValue =
                unit.convertToBaseUnit(value);

        double otherBaseValue =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBaseValue - otherBaseValue)
                < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Objects.hash(
                Math.round(baseValue / EPSILON)
        );
    }

    // ===========================
    // CONVERSION
    // ===========================

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    // ===========================
    // ADDITION
    // ===========================

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        validateQuantity(other);

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double resultBase =
                thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(resultBase);

        return new Quantity<>(result, targetUnit);
    }

    // ===========================
    // SUBTRACTION
    // ===========================

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        validateQuantity(other);

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double resultBase =
                thisBase - otherBase;

        double result =
                targetUnit.convertFromBaseUnit(resultBase);

        result =
                Math.round(result * 100.0) / 100.0;

        return new Quantity<>(result, targetUnit);
    }

    // ===========================
    // DIVISION
    // ===========================

    public double divide(Quantity<U> other) {

        validateQuantity(other);

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        if (Math.abs(otherBase) < EPSILON) {
            throw new ArithmeticException(
                    "Division by zero");
        }

        return thisBase / otherBase;
    }

    // ===========================
    // VALIDATION
    // ===========================

    private void validateQuantity(
            Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (!unit.getClass()
                .equals(other.unit.getClass())) {

            throw new IllegalArgumentException(
                    "Different measurement categories");
        }
    }

    // ===========================
    // TO STRING
    // ===========================

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit.getUnitName() +
                '}';
    }

}