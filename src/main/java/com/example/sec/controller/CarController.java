package com.example.sec.controller;

import com.example.sec.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping(value = "/import")
    public ResponseEntity<String> importCars() {
        try {
            carService.saveCarsFromExternalSite();
            return ResponseEntity.ok("Cars imported successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to import cars: " + e.getMessage());
        }
    }
}
