package com.example;

public class UC8 {

    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(
                feet.convertTo(LengthUnit.INCHES));

        System.out.println(
                feet.add(inches, LengthUnit.FEET));

        QuantityLength q1 =
                new QuantityLength(36.0, LengthUnit.INCHES);

        QuantityLength q2 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        System.out.println(
                q1.equals(q2));

        System.out.println(
                new QuantityLength(1.0, LengthUnit.YARDS)
                        .add(
                                new QuantityLength(
                                        3.0,
                                        LengthUnit.FEET),
                                LengthUnit.YARDS));

        System.out.println(
                new QuantityLength(
                        2.54,
                        LengthUnit.CENTIMETERS)
                        .convertTo(
                                LengthUnit.INCHES));

        System.out.println(
                LengthUnit.FEET
                        .convertToBaseUnit(12.0));

        System.out.println(
                LengthUnit.INCHES
                        .convertToBaseUnit(12.0));
    }
}
