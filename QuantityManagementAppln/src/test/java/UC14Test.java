import com.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UC14Test {
    private static final double EPSILON = 0.01;

    // ==========================================
    // TEMPERATURE EQUALITY TESTS
    // ==========================================

    @Test
    void testTemperatureEquality_CelsiusToCelsius() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        assertEquals(t1, t2);
    }

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertEquals(celsius, fahrenheit);
    }

    @Test
    void testTemperatureEquality_CelsiusToKelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

        assertEquals(celsius, kelvin);
    }

    @Test
    void testTemperatureEquality_Negative40() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(-40.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT);

        assertEquals(celsius, fahrenheit);
    }

    // ==========================================
    // CONVERSION TESTS
    // ==========================================

    @Test
    void testCelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(
                212.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testFahrenheitToCelsius() {

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                fahrenheit.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testKelvinToCelsius() {

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

        Quantity<TemperatureUnit> result =
                kelvin.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testCelsiusToKelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(TemperatureUnit.KELVIN);

        assertEquals(
                273.15,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testRoundTripConversion() {

        Quantity<TemperatureUnit> original =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> converted =
                original.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> back =
                converted.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                original.getValue(),
                back.getValue(),
                EPSILON);
    }

    // ==========================================
    // UNSUPPORTED OPERATIONS
    // ==========================================

    @Test
    void testTemperatureAddUnsupported() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    @Test
    void testTemperatureSubtractUnsupported() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    @Test
    void testTemperatureDivideUnsupported() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }

    // ==========================================
    // OPERATION SUPPORT TESTS
    // ==========================================

    @Test
    void testTemperatureSupportsArithmeticFalse() {

        assertFalse(
                TemperatureUnit.CELSIUS.supportsArithmetic());

        assertFalse(
                TemperatureUnit.FAHRENHEIT.supportsArithmetic());

        assertFalse(
                TemperatureUnit.KELVIN.supportsArithmetic());
    }

    @Test
    void testLengthSupportsArithmeticTrue() {

        assertTrue(
                LengthUnit.FEET.supportsArithmetic());
    }

    @Test
    void testWeightSupportsArithmeticTrue() {

        assertTrue(
                WeightUnit.KILOGRAM.supportsArithmetic());
    }

    @Test
    void testVolumeSupportsArithmeticTrue() {

        assertTrue(
                VolumeUnit.LITRE.supportsArithmetic());
    }

    // ==========================================
    // VALIDATION TESTS
    // ==========================================

    @Test
    void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(100.0, null));
    }

    @Test
    void testInfiniteValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        Double.POSITIVE_INFINITY,
                        TemperatureUnit.CELSIUS));
    }

    @Test
    void testNaNValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        Double.NaN,
                        TemperatureUnit.CELSIUS));
    }

    // ==========================================
    // REFLEXIVE / SYMMETRIC TESTS
    // ==========================================

    @Test
    void testReflexiveEquality() {

        Quantity<TemperatureUnit> temp =
                new Quantity<>(25.0,
                        TemperatureUnit.CELSIUS);

        assertEquals(temp, temp);
    }

    @Test
    void testSymmetricEquality() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(212.0,
                        TemperatureUnit.FAHRENHEIT);

        assertTrue(celsius.equals(fahrenheit));
        assertTrue(fahrenheit.equals(celsius));
    }

    // ==========================================
    // EDGE CASES
    // ==========================================

    @Test
    void testAbsoluteZero() {

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(0.0,
                        TemperatureUnit.KELVIN);

        Quantity<TemperatureUnit> celsius =
                kelvin.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                -273.15,
                celsius.getValue(),
                EPSILON);
    }

    @Test
    void testVeryHighTemperature() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(1000.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                celsius.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(
                1832.0,
                fahrenheit.getValue(),
                EPSILON);
    }
}
