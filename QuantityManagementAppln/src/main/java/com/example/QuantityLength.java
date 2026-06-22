package com.example;

import java.util.Objects;

public class QuantityLength {

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

    private static void validate(
            QuantityLength length1,
            QuantityLength length2) {

        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException(
                    "Lengths cannot be null");
        }
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double epsilon = 0.001;

        return Math.abs(this.value - other.value) < epsilon
                && this.unit == other.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
