package com.example;

public class UC14 {

    public static void main(String[] args) {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN);

        System.out.println(
                "0°C == 32°F : "
                        + celsius.equals(fahrenheit));

        System.out.println(
                "0°C == 273.15K : "
                        + celsius.equals(kelvin));

        System.out.println(
                celsius.convertTo(
                        TemperatureUnit.FAHRENHEIT));

        System.out.println(
                fahrenheit.convertTo(
                        TemperatureUnit.CELSIUS));

        try {
            System.out.println(
                    celsius.add(
                            new Quantity<>(
                                    10.0,
                                    TemperatureUnit.CELSIUS)));
        }
        catch (UnsupportedOperationException e) {
            System.out.println(
                    e.getMessage());
        }
    }
}

