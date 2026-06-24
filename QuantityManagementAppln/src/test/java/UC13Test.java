import com.example.LengthUnit;
import com.example.Quantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UC13Test {
    @Test
    void testAddLength() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.add(q2);

        assertEquals(
                new Quantity<>(2,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testSubtractLength() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.subtract(q2);

        assertEquals(9.5,
                result.getValue());
    }

    @Test
    void testDivideLength() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(24,
                        LengthUnit.INCHES);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2,
                        LengthUnit.FEET);

        assertEquals(
                1.0,
                q1.divide(q2));
    }

    @Test
    void testNullOperand() {

        Quantity<LengthUnit> q =
                new Quantity<>(10,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q.add(null));
    }

    @Test
    void testDivideByZero() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0,
                        LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> q1.divide(q2));
    }

    @Test
    void testImmutability() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12,
                        LengthUnit.INCHES);

        q1.add(q2);

        assertEquals(1,
                q1.getValue());

        assertEquals(
                LengthUnit.FEET,
                q1.getUnit());
    }
}
