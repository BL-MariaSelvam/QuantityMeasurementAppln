package com.example;

import java.util.Objects;

public class UC7 {
    public static void main(String[] args) {

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(1.0, LengthUnit.FEET),
                        new QuantityLength(12.0, LengthUnit.INCHES),
                        LengthUnit.FEET));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(1.0, LengthUnit.FEET),
                        new QuantityLength(12.0, LengthUnit.INCHES),
                        LengthUnit.INCHES));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(1.0, LengthUnit.FEET),
                        new QuantityLength(12.0, LengthUnit.INCHES),
                        LengthUnit.YARDS));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(1.0, LengthUnit.YARDS),
                        new QuantityLength(3.0, LengthUnit.FEET),
                        LengthUnit.YARDS));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(36.0, LengthUnit.INCHES),
                        new QuantityLength(1.0, LengthUnit.YARDS),
                        LengthUnit.FEET));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(2.54, LengthUnit.CENTIMETERS),
                        new QuantityLength(1.0, LengthUnit.INCHES),
                        LengthUnit.CENTIMETERS));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(5.0, LengthUnit.FEET),
                        new QuantityLength(0.0, LengthUnit.INCHES),
                        LengthUnit.YARDS));

        System.out.println(
                QuantityLength.add(
                        new QuantityLength(5.0, LengthUnit.FEET),
                        new QuantityLength(-2.0, LengthUnit.FEET),
                        LengthUnit.INCHES));
    }
}
