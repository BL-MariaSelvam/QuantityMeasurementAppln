package com.example;

import java.util.Objects;

public class QuantityLength {

    private static final double EPSILON = 0.001;
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
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

    public LengthUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }

    private static double roundToThreeDecimals(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    private static QuantityLength addInternal(
            QuantityLength length1,
            QuantityLength length2,
            LengthUnit targetUnit) {

        double baseSum = length1.toBaseUnit() + length2.toBaseUnit();

        double resultValue = baseSum / targetUnit.getConversionFactor();

        return new QuantityLength(
                roundToThreeDecimals(resultValue),
                targetUnit
        );
    }

    // UC6 - Result in first operand unit
    public static QuantityLength add(
            QuantityLength length1,
            QuantityLength length2) {

        validate(length1, length2);

        return addInternal(length1, length2, length1.getUnit());
    }

    // UC7 - Result in specified target unit
    public static QuantityLength add(
            QuantityLength length1,
            QuantityLength length2,
            LengthUnit targetUnit) {

        validate(length1, length2);

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        return addInternal(length1, length2, targetUnit);
    }

    public QuantityLength add(
            QuantityLength other,
            LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityLength(result, targetUnit);
    }
    private static void validate(
            QuantityLength length1,
            QuantityLength length2) {

        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException(
                    "Lengths cannot be null");
        }
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityLength(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityLength)) {
            return false;
        }

        QuantityLength other = (QuantityLength) obj;

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
