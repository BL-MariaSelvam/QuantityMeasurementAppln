import com.example.UC4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC4Test {

    @Test
    void testEquality_YardToYard_SameValue() {

        UC4.QuantityLength q1 =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength q2 =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        Assertions.assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {

        UC4.QuantityLength q1 =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength q2 =
                new UC4.QuantityLength(2.0, UC4.LengthUnit.YARDS);

        Assertions.assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength feet =
                new UC4.QuantityLength(3.0, UC4.LengthUnit.FEET);

        Assertions.assertTrue(yard.equals(feet));
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {

        UC4.QuantityLength feet =
                new UC4.QuantityLength(3.0, UC4.LengthUnit.FEET);

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        Assertions.assertTrue(feet.equals(yard));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength inch =
                new UC4.QuantityLength(36.0, UC4.LengthUnit.INCH);

        Assertions.assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {

        UC4.QuantityLength inch =
                new UC4.QuantityLength(36.0, UC4.LengthUnit.INCH);

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        Assertions.assertTrue(inch.equals(yard));
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength feet =
                new UC4.QuantityLength(2.0, UC4.LengthUnit.FEET);

        Assertions.assertFalse(yard.equals(feet));
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {

        UC4.QuantityLength cm =
                new UC4.QuantityLength(1.0,
                        UC4.LengthUnit.CENTIMETERS);

        UC4.QuantityLength inch =
                new UC4.QuantityLength(0.393701,
                        UC4.LengthUnit.INCH);

        Assertions.assertTrue(cm.equals(inch));
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {

        UC4.QuantityLength cm =
                new UC4.QuantityLength(1.0,
                        UC4.LengthUnit.CENTIMETERS);

        UC4.QuantityLength feet =
                new UC4.QuantityLength(1.0,
                        UC4.LengthUnit.FEET);

        Assertions.assertFalse(cm.equals(feet));
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength feet =
                new UC4.QuantityLength(3.0, UC4.LengthUnit.FEET);

        UC4.QuantityLength inch =
                new UC4.QuantityLength(36.0, UC4.LengthUnit.INCH);

        Assertions.assertTrue(yard.equals(feet));
        Assertions.assertTrue(feet.equals(inch));
        Assertions.assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_SameReference() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        Assertions.assertTrue(yard.equals(yard));
    }

    @Test
    void testEquality_NullComparison() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(1.0, UC4.LengthUnit.YARDS);

        Assertions.assertFalse(yard.equals(null));
    }

    @Test
    void testEquality_NullUnit() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new UC4.QuantityLength(1.0, null)
        );
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {

        UC4.QuantityLength yard =
                new UC4.QuantityLength(2.0, UC4.LengthUnit.YARDS);

        UC4.QuantityLength feet =
                new UC4.QuantityLength(6.0, UC4.LengthUnit.FEET);

        UC4.QuantityLength inch =
                new UC4.QuantityLength(72.0, UC4.LengthUnit.INCH);

        Assertions.assertTrue(yard.equals(feet));
        Assertions.assertTrue(feet.equals(inch));
        Assertions.assertTrue(yard.equals(inch));
    }
}
