import com.example.UC5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC5Test {
    private static final double EPSILON = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        Assertions.assertEquals(
                12.0,
                UC5.QuantityLength.convert(
                        1.0,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        Assertions.assertEquals(
                2.0,
                UC5.QuantityLength.convert(
                        24.0,
                        UC5.LengthUnit.INCH,
                        UC5.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {
        Assertions.assertEquals(
                36.0,
                UC5.QuantityLength.convert(
                        1.0,
                        UC5.LengthUnit.YARDS,
                        UC5.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_InchesToYards() {
        Assertions.assertEquals(
                2.0,
                UC5.QuantityLength.convert(
                        72.0,
                        UC5.LengthUnit.INCH,
                        UC5.LengthUnit.YARDS),
                EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        Assertions.assertEquals(
                1.0,
                UC5.QuantityLength.convert(
                        2.54,
                        UC5.LengthUnit.CENTIMETERS,
                        UC5.LengthUnit.INCH),
                1e-3);
    }

    @Test
    void testConversion_FeetToYards() {
        Assertions.assertEquals(
                2.0,
                UC5.QuantityLength.convert(
                        6.0,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.YARDS),
                EPSILON);
    }

    @Test
    void testConversion_RoundTrip_PreservesValue() {

        double original = 5.0;

        double converted =
                UC5.QuantityLength.convert(
                        original,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.INCH);

        double result =
                UC5.QuantityLength.convert(
                        converted,
                        UC5.LengthUnit.INCH,
                        UC5.LengthUnit.FEET);

        Assertions.assertEquals(
                original,
                result,
                EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {

        Assertions.assertEquals(
                0.0,
                UC5.QuantityLength.convert(
                        0.0,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {

        Assertions.assertEquals(
                -12.0,
                UC5.QuantityLength.convert(
                        -1.0,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.INCH),
                EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> UC5.QuantityLength.convert(
                        1.0,
                        null,
                        UC5.LengthUnit.FEET));
    }

    @Test
    void testConversion_NaN_Throws() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> UC5.QuantityLength.convert(
                        Double.NaN,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.INCH));
    }

    @Test
    void testConversion_Infinite_Throws() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> UC5.QuantityLength.convert(
                        Double.POSITIVE_INFINITY,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.INCH));
    }

    @Test
    void testConversion_PrecisionTolerance() {

        double result =
                UC5.QuantityLength.convert(
                        2.54,
                        UC5.LengthUnit.CENTIMETERS,
                        UC5.LengthUnit.INCH);

        Assertions.assertEquals(
                1.0,
                result,
                1e-3);
    }

    @Test
    void testConversion_SameUnit() {

        Assertions.assertEquals(
                5.0,
                UC5.QuantityLength.convert(
                        5.0,
                        UC5.LengthUnit.FEET,
                        UC5.LengthUnit.FEET),
                EPSILON);
    }
}
