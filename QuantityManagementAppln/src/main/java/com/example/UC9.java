package com.example;

public class UC9 {

    public static void main(String[] args) {

        QuantityWeight kg =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight pound =
                new QuantityWeight(2.20462, WeightUnit.POUND);

        // Equality
        System.out.println(kg.equals(gram));

        // Conversion
        System.out.println(
                kg.convertTo(WeightUnit.GRAM));

        System.out.println(
                pound.convertTo(WeightUnit.KILOGRAM));

        // Addition (implicit target unit)
        System.out.println(
                kg.add(gram));

        // Addition (explicit target unit)
        System.out.println(
                kg.add(gram, WeightUnit.GRAM));

        System.out.println(
                new QuantityWeight(1.0, WeightUnit.POUND)
                        .add(
                                new QuantityWeight(
                                        453.592,
                                        WeightUnit.GRAM),
                                WeightUnit.POUND));

        // Category safety
        QuantityLength length =
                new QuantityLength(1.0, LengthUnit.FEET);

        System.out.println(
                kg.equals(length));   // false
    }
}
