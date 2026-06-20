import com.example.UC3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC3Test {

    @Test
    void testEquality_FeetToFeet_SameValue() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        UC3.QuantityLength q2 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        Assertions.assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.INCH);

        UC3.QuantityLength q2 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.INCH);

        Assertions.assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {

        UC3.QuantityLength feet =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        UC3.QuantityLength inch =
                new UC3.QuantityLength(12.0, UC3.LengthUnit.INCH);

        Assertions.assertTrue(feet.equals(inch));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {

        UC3.QuantityLength inch =
                new UC3.QuantityLength(12.0, UC3.LengthUnit.INCH);

        UC3.QuantityLength feet =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        Assertions.assertTrue(inch.equals(feet));
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        UC3.QuantityLength q2 =
                new UC3.QuantityLength(2.0, UC3.LengthUnit.FEET);

        Assertions.assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.INCH);

        UC3.QuantityLength q2 =
                new UC3.QuantityLength(2.0, UC3.LengthUnit.INCH);

        Assertions.assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_SameReference() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        Assertions.assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_NullComparison() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        Assertions.assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {

        UC3.QuantityLength q1 =
                new UC3.QuantityLength(1.0, UC3.LengthUnit.FEET);

        Assertions.assertFalse(q1.equals("ABC"));
    }

    @Test
    void testEquality_NullUnit() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new UC3.QuantityLength(1.0, null)
        );
    }
}
