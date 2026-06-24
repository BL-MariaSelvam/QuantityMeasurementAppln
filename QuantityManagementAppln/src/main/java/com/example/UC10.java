package com.example;

public class UC10 {

    public static <U extends Enum<U> & IMeasurable>
    void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(
                q1 + " equals " + q2 +
                        " : " + q1.equals(q2));
    }

    public static <U extends Enum<U> & IMeasurable>
    void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        System.out.println(
                quantity.convertTo(targetUnit));
    }

    public static <U extends Enum<U> & IMeasurable>
    void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(
                q1.add(q2, targetUnit));
    }

    public static void main(String[] args) {

        // Length Examples
        Quantity<LengthUnit> foot =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("=== Length Operations ===");

        demonstrateEquality(foot, inch);

        demonstrateConversion(
                foot,
                LengthUnit.INCHES);

        demonstrateAddition(
                foot,
                inch,
                LengthUnit.FEET);

        // Weight Examples
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("\n=== Weight Operations ===");

        demonstrateEquality(kg, gram);

        demonstrateConversion(
                kg,
                WeightUnit.GRAM);

        demonstrateAddition(
                kg,
                gram,
                WeightUnit.KILOGRAM);
    }
}