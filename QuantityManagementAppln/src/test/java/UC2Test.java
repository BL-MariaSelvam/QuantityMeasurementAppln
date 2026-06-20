import com.example.UC2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UC2Test {
    @Test
    void testFeetEquality_SameValue() {
        UC2.Feet feet1 = new UC2.Feet(1.0);
        UC2.Feet feet2 = new UC2.Feet(1.0);

        Assertions.assertTrue(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        UC2.Feet feet1 = new UC2.Feet(1.0);
        UC2.Feet feet2 = new UC2.Feet(2.0);

        Assertions.assertFalse(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_NullComparison() {
        UC2.Feet feet = new UC2.Feet(1.0);

        Assertions.assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        UC2.Feet feet = new UC2.Feet(1.0);

        Assertions.assertFalse(feet.equals("ABC"));
    }

    @Test
    void testFeetEquality_SameReference() {
        UC2.Feet feet = new UC2.Feet(1.0);

        Assertions.assertTrue(feet.equals(feet));
    }

    // INCHES TEST CASES

    @Test
    void testInchesEquality_SameValue() {
        UC2.Inches inch1 = new UC2.Inches(1.0);
        UC2.Inches inch2 = new UC2.Inches(1.0);

        Assertions.assertTrue(inch1.equals(inch2));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        UC2.Inches inch1 = new UC2.Inches(1.0);
        UC2.Inches inch2 = new UC2.Inches(2.0);

        Assertions.assertFalse(inch1.equals(inch2));
    }

    @Test
    void testInchesEquality_NullComparison() {
        UC2.Inches inch = new UC2.Inches(1.0);

        Assertions.assertFalse(inch.equals(null));
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        UC2.Inches inch = new UC2.Inches(1.0);

        Assertions.assertFalse(inch.equals("ABC"));
    }

    @Test
    void testInchesEquality_SameReference() {
        UC2.Inches inch = new UC2.Inches(1.0);

        Assertions.assertTrue(inch.equals(inch));
    }
}
