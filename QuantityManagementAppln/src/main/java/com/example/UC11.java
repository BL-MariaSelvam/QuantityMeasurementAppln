package com.example;

public class UC11 {

    public static void main(String[] args) {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> volume3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        // Equality
        System.out.println("1 L == 1000 mL : "
                + volume1.equals(volume2));

        // Conversion
        System.out.println("1 L to mL : "
                + volume1.convertTo(VolumeUnit.MILLILITRE));

        System.out.println("1 Gallon to Litre : "
                + volume3.convertTo(VolumeUnit.LITRE));

        // Addition
        System.out.println("1 L + 1000 mL : "
                + volume1.add(volume2));

        System.out.println("1 L + 1 Gallon in mL : "
                + volume1.add(volume3, VolumeUnit.MILLILITRE));
    }
}
