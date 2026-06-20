import com.example.UC1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UC1Test {
    @Test
    void testEquality_SameValue() {
        UC1.Feet feet1 =
                new UC1.Feet(1.0);
        UC1.Feet feet2 =
                new UC1.Feet(1.0);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    void testEquality_DifferentValue() {
        UC1.Feet feet1 =
                new UC1.Feet(1.0);
        UC1.Feet feet2 =
                new UC1.Feet(2.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    void testEquality_NullComparison() {
        UC1.Feet feet =
                new UC1.Feet(1.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {
        UC1.Feet feet =
                new UC1.Feet(1.0);

        assertFalse(feet.equals("ABC"));
    }

    @Test
    void testEquality_SameReference() {
        UC1.Feet feet =
                new UC1.Feet(1.0);

        assertTrue(feet.equals(feet));
    }
}
