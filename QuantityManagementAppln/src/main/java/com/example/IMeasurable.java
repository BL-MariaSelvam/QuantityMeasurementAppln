package com.example;

public interface IMeasurable {


    SupportsArithmetic SUPPORTS_ARITHMETIC = () -> true;

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    default boolean supportsArithmetic() {
        return SUPPORTS_ARITHMETIC.isSupported();
    }

    default void validateOperationSupport(String operation) {
        // By default all operations supported
    }
}
