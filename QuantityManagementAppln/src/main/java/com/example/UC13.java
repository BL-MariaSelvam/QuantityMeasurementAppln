package com.example;

public class UC13 {
    public static void main(String[] args) {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12, LengthUnit.INCHES);

        System.out.println(
                q1.add(q2));

        Quantity<LengthUnit> q3 =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> q4 =
                new Quantity<>(6, LengthUnit.INCHES);

        System.out.println(
                q3.subtract(q4));

        Quantity<LengthUnit> q5 =
                new Quantity<>(24, LengthUnit.INCHES);

        Quantity<LengthUnit> q6 =
                new Quantity<>(2, LengthUnit.FEET);

        System.out.println(
                q5.divide(q6));

        Quantity<WeightUnit> w1 =
                new Quantity<>(10, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5000, WeightUnit.GRAM);

        System.out.println(
                w1.add(w2, WeightUnit.GRAM));

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(2, VolumeUnit.LITRE);

        System.out.println(
                v1.subtract(v2,
                        VolumeUnit.MILLILITRE));
    }
}
