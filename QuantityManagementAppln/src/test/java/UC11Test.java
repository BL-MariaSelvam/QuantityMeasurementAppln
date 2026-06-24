import com.example.Quantity;
import com.example.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UC11Test {

    @Test
    void testEquality_LitreToMillilitre() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliLitre =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(litre, milliLitre);
    }

    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.0001);
    }

    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result.getValue(), 0.0001);
    }

    @Test
    void testAddition_LitrePlusMillilitre() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliLitre =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = litre.add(milliLitre);

        assertEquals(2.0, result.getValue(), 0.0001);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> milliLitre =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(milliLitre, VolumeUnit.MILLILITRE);

        assertEquals(2000.0, result.getValue(), 0.0001);
    }

}
