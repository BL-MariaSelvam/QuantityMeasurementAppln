package com.example;

import com.example.controller.QuantityMeasurementController;
import com.example.dto.QuantityDTO;
import com.example.repository.IQuantityMeasurementRepository;
import com.example.service.IQuantityMeasurementService;
import com.example.service.QuantityMeasurementServiceImpl;
import com.example.util.DatabaseInitializer;

public class UC16 {
    public static void main(String[] args) {

        //  Initialize DB
        DatabaseInitializer.init();

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementDatabaseRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.performComparison(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCHES", "LENGTH")
        );
    }
}
