package com.example;

import com.example.controller.QuantityMeasurementController;
import com.example.dto.QuantityDTO;
import com.example.repository.IQuantityMeasurementRepository;
import com.example.repository.QuantityMeasurementCacheRepository;
import com.example.service.IQuantityMeasurementService;
import com.example.service.QuantityMeasurementServiceImpl;

public class UC15 {
    public static void main(String[] args) {

        // Factory + DI
        IQuantityMeasurementRepository repo =
                QuantityMeasurementCacheRepository.getInstance();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // Example Usage
        controller.performComparison(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCHES", "LENGTH")
        );

        controller.performConversion(
                new QuantityDTO(100, "CELSIUS", "TEMPERATURE"),
                "FAHRENHEIT"
        );

        controller.performAddition(
                new QuantityDTO(1, "KILOGRAM", "WEIGHT"),
                new QuantityDTO(1000, "GRAM", "WEIGHT")
        );
    }
}
