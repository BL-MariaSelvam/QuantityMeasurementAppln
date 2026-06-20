package com.example;

public class UC2 {
    // Feet Class
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Feet feet = (Feet) obj;
            return Double.compare(this.value, feet.value) == 0;
        }
    }

    // Inches Class
   public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Inches inches = (Inches) obj;
            return Double.compare(this.value, inches.value) == 0;
        }
    }

    // Method to check feet equality
    public static boolean areFeetEqual(double value1, double value2) {
        Feet feet1 = new Feet(value1);
        Feet feet2 = new Feet(value2);
        return feet1.equals(feet2);
    }

    // Method to check inches equality
    public static boolean areInchesEqual(double value1, double value2) {
        Inches inch1 = new Inches(value1);
        Inches inch2 = new Inches(value2);
        return inch1.equals(inch2);
    }

    public static void main(String[] args) {

        System.out.println("1.0 ft and 1.0 ft Equal : "
                + areFeetEqual(1.0, 1.0));

        System.out.println("1.0 inch and 1.0 inch Equal : "
                + areInchesEqual(1.0, 1.0));
    }
}
