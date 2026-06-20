package com.example;

public class UC4 {
    public enum LengthUnit {

        FEET(12.0),          // base unit = inches
        INCH(1.0),
        YARDS(36.0),         // 1 yard = 36 inches
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

            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        private double toInches() {
            return value * unit.getConversionFactor();
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(
                    this.toInches(),
                    other.toInches()) == 0;
        }
    }

    public static void main(String[] args) {

        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(36.0, LengthUnit.INCH);

        QuantityLength cm =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);

        System.out.println(yard.equals(feet));      // true
        System.out.println(yard.equals(inches));    // true
        System.out.println(cm.equals(
                new QuantityLength(0.393701,
                        LengthUnit.INCH)));         // true
    }
}
