package com.example;

public class UC6 {
    public enum LengthUnit {
        INCH(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }

            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
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

        public QuantityLength convertTo(LengthUnit targetUnit) {

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double baseValue = toBaseUnit();
            double convertedValue =
                    baseValue / targetUnit.getConversionFactor();

            return new QuantityLength(convertedValue, targetUnit);
        }

        public static double convert(
                double value,
                LengthUnit sourceUnit,
                LengthUnit targetUnit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }

            if (sourceUnit == null || targetUnit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            double baseValue =
                    value * sourceUnit.getConversionFactor();

            return baseValue / targetUnit.getConversionFactor();
        }

        public QuantityLength add(QuantityLength other) {

            if (other == null) {
                throw new IllegalArgumentException(
                        "Second operand cannot be null");
            }

            double totalBaseValue =
                    this.toBaseUnit() + other.toBaseUnit();

            double resultValue =
                    totalBaseValue / this.unit.getConversionFactor();

            return new QuantityLength(resultValue, this.unit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(
                    this.toBaseUnit() - other.toBaseUnit())
                    < 0.000001;
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result = feet.add(inches);

        System.out.println("Addition Result : " + result);

        System.out.println(
                "1 Foot equals 12 Inches : "
                        + feet.equals(inches));

        System.out.println(
                "1 Yard to Feet : "
                        + QuantityLength.convert(
                        1.0,
                        LengthUnit.YARDS,
                        LengthUnit.FEET));

        System.out.println(
                "36 Inches to Yards : "
                        + QuantityLength.convert(
                        36.0,
                        LengthUnit.INCH,
                        LengthUnit.YARDS));

        System.out.println(
                "2.54 CM to Inches : "
                        + QuantityLength.convert(
                        2.54,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.INCH));
    }
}
