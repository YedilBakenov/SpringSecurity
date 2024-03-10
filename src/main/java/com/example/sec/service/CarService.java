package com.example.sec.service;

import com.example.sec.dto.CarDTO;
import com.example.sec.mapper.carMapper;
import com.example.sec.model.Car;
import com.example.sec.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final carMapper carMapper;

    public void saveCarsFromExternalSite() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://kolesa.kz/cars/mercedes-benz/almaty/";

    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            CarDTO[] carArray = mapper.readValue(response.getBody(), CarDTO[].class);
            List<Car> cars = Arrays.stream(carArray)
                    .map(carMapper::toCar)
                    .collect(Collectors.toList());

            carRepository.saveAll(cars);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}