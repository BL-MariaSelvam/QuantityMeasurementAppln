import com.example.LengthUnit;
import com.example.Quantity;
import com.example.VolumeUnit;
import com.example.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UC12Test {
    private static final double EPSILON = 0.0001;

    // ===========================
    // SUBTRACTION TESTS
    // ===========================

    @Test
    void testSubtraction_SameUnit_FeetMinusFeet() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_CrossUnit_FeetMinusInches() {
        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_ExplicitTargetUnit() {
        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(inches, LengthUnit.INCHES);

        assertEquals(114.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_ResultingInNegative() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(-5.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_ResultingInZero() {
        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(120.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(0.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_NullOperand() {
        Quantity<LengthUnit> quantity =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.subtract(null)
        );
    }

    @Test
    void testSubtraction_NullTargetUnit() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract(q2, null)
        );
    }

    @Test
    void testSubtraction_Volume() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliLitre =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.subtract(milliLitre);

        assertEquals(4.5, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_Weight() {
        Quantity<WeightUnit> kg =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(5000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kg.subtract(gram);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    // ===========================
    // DIVISION TESTS
    // ===========================

    @Test
    void testDivision_SameUnit() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(5.0, q1.divide(q2), EPSILON);
    }

    @Test
    void testDivision_CrossUnit_Length() {
        Quantity<LengthUnit> inches =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(1.0, inches.divide(feet), EPSILON);
    }

    @Test
    void testDivision_CrossUnit_Weight() {
        Quantity<WeightUnit> kg =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(2000.0, WeightUnit.GRAM);

        assertEquals(1.0, kg.divide(gram), EPSILON);
    }

    @Test
    void testDivision_CrossUnit_Volume() {
        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(1.0, ml.divide(litre), EPSILON);
    }

    @Test
    void testDivision_RatioGreaterThanOne() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertEquals(2.0, q1.divide(q2), EPSILON);
    }

    @Test
    void testDivision_RatioLessThanOne() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertEquals(0.5, q1.divide(q2), EPSILON);
    }

    @Test
    void testDivision_RatioEqualToOne() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertEquals(1.0, q1.divide(q2), EPSILON);
    }

    @Test
    void testDivision_ByZero() {
        Quantity<LengthUnit> value =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> zero =
                new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> value.divide(zero)
        );
    }

    @Test
    void testDivision_NullOperand() {
        Quantity<LengthUnit> quantity =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.divide(null)
        );
    }

    @Test
    void testDivision_LargeRatio() {
        Quantity<WeightUnit> large =
                new Quantity<>(1_000_000.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> small =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertEquals(
                1_000_000.0,
                large.divide(small),
                EPSILON
        );
    }

    @Test
    void testDivision_SmallRatio() {
        Quantity<WeightUnit> small =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> large =
                new Quantity<>(1_000_000.0, WeightUnit.KILOGRAM);

        assertEquals(
                0.000001,
                small.divide(large),
                EPSILON
        );
    }

    // ===========================
    // IMMUTABILITY TESTS
    // ===========================

    @Test
    void testSubtraction_Immutability() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        q1.subtract(q2);

        assertEquals(10.0, q1.getValue(), EPSILON);
        assertEquals(5.0, q2.getValue(), EPSILON);
    }

    @Test
    void testDivision_Immutability() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        q1.divide(q2);

        assertEquals(10.0, q1.getValue(), EPSILON);
        assertEquals(5.0, q2.getValue(), EPSILON);
    }
}
