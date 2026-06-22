import com.example.LengthUnit;
import com.example.Quantity;
import com.example.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UC10Test {

    @Test
    void testGenericQuantity_LengthEquality() {

        Quantity<LengthUnit> foot =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0,
                        LengthUnit.INCHES);

        assertEquals(foot, inches);
    }

    @Test
    void testGenericQuantity_WeightEquality() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testLengthConversion() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0,
                        LengthUnit.FEET)
                        .convertTo(
                                LengthUnit.INCHES);

        assertEquals(
                12.0,
                result.getValue());
    }

    @Test
    void testWeightConversion() {

        Quantity<WeightUnit> result =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM);

        assertEquals(
                1000.0,
                result.getValue());
    }

    @Test
    void testLengthAddition() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0,
                        LengthUnit.FEET)
                        .add(
                                new Quantity<>(
                                        12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.FEET);

        assertEquals(
                2.0,
                result.getValue());
    }

    @Test
    void testWeightAddition() {

        Quantity<WeightUnit> result =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Quantity<>(
                                        1000.0,
                                        WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(
                2.0,
                result.getValue());
    }

    @Test
    void testCrossCategoryPrevention() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    void testConstructorValidation_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testConstructorValidation_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        Double.NaN,
                        LengthUnit.FEET));
    }

    @Test
    void testHashCodeConsistency() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(
                q1.hashCode(),
                q2.hashCode());
    }
}
