package com.example;

public class UC1 {

    // Inner class Feet
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj) {
                return true;
            }

            // Null and type check
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Cast and compare values
            Feet feet = (Feet) obj;
            return Double.compare(this.value, feet.value) == 0;
        }
    }

    public static void main(String[] args) {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        System.out.println("Equal: " + feet1.equals(feet2));
    }
}
