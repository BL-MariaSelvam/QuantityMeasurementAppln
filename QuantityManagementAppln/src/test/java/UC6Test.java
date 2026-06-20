package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC6Test {

    private static final double EPSILON = 0.001;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        UC6.QuantityLength q1 =
                new UC6.QuantityLength(1.0, UC6.LengthUnit.FEET);

        UC6.QuantityLength q2 =
                new UC6.QuantityLength(2.0, UC6.LengthUnit.FEET);

        UC6.QuantityLength result = q1.add(q2);

        Assertions.assertEquals(3.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {
        UC6.QuantityLength q1 =
                new UC6.QuantityLength(6.0, UC6.LengthUnit.INCH);

        UC6.QuantityLength q2 =
                new UC6.QuantityLength(6.0, UC6.LengthUnit.INCH);

        UC6.QuantityLength result = q1.add(q2);

        Assertions.assertEquals(12.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        UC6.QuantityLength feet =
                new UC6.QuantityLength(1.0, UC6.LengthUnit.FEET);

        UC6.QuantityLength inches =
                new UC6.QuantityLength(12.0, UC6.LengthUnit.INCH);

        UC6.QuantityLength result = feet.add(inches);

        Assertions.assertEquals(2.0,
                result.getValue(),
                EPSILON);

        Assertions.assertEquals(
                UC6.LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        UC6.QuantityLength inches =
                new UC6.QuantityLength(12.0, UC6.LengthUnit.INCH);

        UC6.QuantityLength feet =
                new UC6.QuantityLength(1.0, UC6.LengthUnit.FEET);

        UC6.QuantityLength result = inches.add(feet);

        Assertions.assertEquals(24.0,
                result.getValue(),
                EPSILON);

        Assertions.assertEquals(
                UC6.LengthUnit.INCH,
                result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_YardPlusFeet() {
        UC6.QuantityLength yard =
                new UC6.QuantityLength(1.0, UC6.LengthUnit.YARDS);

        UC6.QuantityLength feet =
                new UC6.QuantityLength(3.0, UC6.LengthUnit.FEET);

        UC6.QuantityLength result = yard.add(feet);

        Assertions.assertEquals(2.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {
        UC6.QuantityLength cm =
                new UC6.QuantityLength(2.54,
                        UC6.LengthUnit.CENTIMETERS);

        UC6.QuantityLength inch =
                new UC6.QuantityLength(1.0,
                        UC6.LengthUnit.INCH);

        UC6.QuantityLength result = cm.add(inch);

        Assertions.assertEquals(5.08,
                result.getValue(),
                0.01);
    }

    @Test
    void testAddition_Commutativity() {

        UC6.QuantityLength feet =
                new UC6.QuantityLength(1.0,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength inches =
                new UC6.QuantityLength(12.0,
                        UC6.LengthUnit.INCH);

        UC6.QuantityLength result1 = feet.add(inches);
        UC6.QuantityLength result2 = inches.add(feet);

        Assertions.assertTrue(
                result1.equals(
                        new UC6.QuantityLength(
                                2.0,
                                UC6.LengthUnit.FEET)));

        Assertions.assertTrue(
                result2.equals(
                        new UC6.QuantityLength(
                                24.0,
                                UC6.LengthUnit.INCH)));
    }

    @Test
    void testAddition_WithZero() {
        UC6.QuantityLength feet =
                new UC6.QuantityLength(5.0,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength zero =
                new UC6.QuantityLength(0.0,
                        UC6.LengthUnit.INCH);

        UC6.QuantityLength result = feet.add(zero);

        Assertions.assertEquals(5.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        UC6.QuantityLength q1 =
                new UC6.QuantityLength(5.0,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength q2 =
                new UC6.QuantityLength(-2.0,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength result = q1.add(q2);

        Assertions.assertEquals(3.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_NullSecondOperand() {
        UC6.QuantityLength q1 =
                new UC6.QuantityLength(1.0,
                        UC6.LengthUnit.FEET);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> q1.add(null));
    }

    @Test
    void testAddition_LargeValues() {
        UC6.QuantityLength q1 =
                new UC6.QuantityLength(1000000,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength q2 =
                new UC6.QuantityLength(1000000,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength result = q1.add(q2);

        Assertions.assertEquals(
                2000000,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_SmallValues() {
        UC6.QuantityLength q1 =
                new UC6.QuantityLength(0.001,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength q2 =
                new UC6.QuantityLength(0.002,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength result = q1.add(q2);

        Assertions.assertEquals(
                0.003,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testEquality_FeetAndInches() {
        UC6.QuantityLength feet =
                new UC6.QuantityLength(1.0,
                        UC6.LengthUnit.FEET);

        UC6.QuantityLength inches =
                new UC6.QuantityLength(12.0,
                        UC6.LengthUnit.INCH);

        Assertions.assertTrue(feet.equals(inches));
    }

    @Test
    void testConversion_YardToFeet() {
        double result =
                UC6.QuantityLength.convert(
                        1.0,
                        UC6.LengthUnit.YARDS,
                        UC6.LengthUnit.FEET);

        Assertions.assertEquals(3.0,
                result,
                EPSILON);
    }

    @Test
    void testConversion_CentimeterToInch() {
        double result =
                UC6.QuantityLength.convert(
                        2.54,
                        UC6.LengthUnit.CENTIMETERS,
                        UC6.LengthUnit.INCH);

        Assertions.assertEquals(1.0,
                result,
                0.01);
    }
}
