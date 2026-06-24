package com.example;

public class UC12 {
    public static void main(String[] args) {

        System.out.println("===== UC12 Quantity Measurement Application =====");

        // ==========================
        // LENGTH OPERATIONS
        // ==========================
        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("\n----- LENGTH -----");

        System.out.println("Feet: " + feet);
        System.out.println("Inches: " + inches);

        System.out.println("Addition: "
                + feet.add(inches));

        System.out.println("Subtraction: "
                + feet.subtract(inches));

        System.out.println("Subtraction (Inches): "
                + feet.subtract(inches, LengthUnit.INCHES));

        System.out.println("Division: "
                + feet.divide(inches));

        // ==========================
        // WEIGHT OPERATIONS
        // ==========================
        Quantity<WeightUnit> kilogram =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println("\n----- WEIGHT -----");

        System.out.println("Kilogram: " + kilogram);
        System.out.println("Gram: " + gram);

        System.out.println("Addition: "
                + kilogram.add(gram));

        System.out.println("Subtraction: "
                + kilogram.subtract(gram));

        System.out.println("Subtraction (Gram): "
                + kilogram.subtract(gram, WeightUnit.GRAM));

        System.out.println("Division: "
                + kilogram.divide(gram));

        // ==========================
        // VOLUME OPERATIONS
        // ==========================
        Quantity<VolumeUnit> litre =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliLitre =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("\n----- VOLUME -----");

        System.out.println("Litre: " + litre);
        System.out.println("Millilitre: " + milliLitre);

        System.out.println("Addition: "
                + litre.add(milliLitre));

        System.out.println("Subtraction: "
                + litre.subtract(milliLitre));

        System.out.println("Subtraction (Millilitre): "
                + litre.subtract(milliLitre,
                VolumeUnit.MILLILITRE));

        System.out.println("Division: "
                + litre.divide(milliLitre));

        // ==========================
        // CONVERSIONS
        // ==========================
        System.out.println("\n----- CONVERSIONS -----");

        System.out.println("10 Feet to Inches: "
                + feet.convertTo(LengthUnit.INCHES));

        System.out.println("10 Kilogram to Gram: "
                + kilogram.convertTo(WeightUnit.GRAM));

        System.out.println("5 Litre to Millilitre: "
                + litre.convertTo(VolumeUnit.MILLILITRE));

        // ==========================
        // EQUALITY
        // ==========================
        System.out.println("\n----- EQUALITY -----");

        Quantity<VolumeUnit> oneLitre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> thousandMl =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        System.out.println("1 Litre == 1000 mL ? "
                + oneLitre.equals(thousandMl));

        // ==========================
        // ERROR HANDLING
        // ==========================
        System.out.println("\n----- ERROR HANDLING -----");

        try {
            Quantity<LengthUnit> value =
                    new Quantity<>(10.0,
                            LengthUnit.FEET);

            Quantity<LengthUnit> zero =
                    new Quantity<>(0.0,
                            LengthUnit.FEET);

            System.out.println(value.divide(zero));

        } catch (ArithmeticException e) {
            System.out.println("Error: "
                    + e.getMessage());
        }

        System.out.println("\n===== APPLICATION COMPLETED =====");
    }
}
