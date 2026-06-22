import com.example.LengthUnit;
import com.example.QuantityLength;
import com.example.QuantityWeight;
import com.example.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UC9Test {
    private static final double EPSILON = 0.0001;

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {
        QuantityWeight kg =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testConversion_KilogramToGram() {

        QuantityWeight result =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM);

        assertEquals(
                1000.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {

        QuantityWeight result =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(
                                        1000.0,
                                        WeightUnit.GRAM));

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Gram() {

        QuantityWeight result =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(
                                        1000.0,
                                        WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(
                2000.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConstructor_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    @Test
    void testConvertTo_NullTargetUnit() {

        QuantityWeight weight =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> weight.convertTo(null));
    }

    @Test
    void testAdd_NullWeight() {

        QuantityWeight weight =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> weight.add(null));
    }

    @Test
    void testWeightVsLength_Incompatible() {

        QuantityWeight weight =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityLength length =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(weight.equals(length));
    }
}
