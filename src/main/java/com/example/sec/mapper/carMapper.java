package com.example.sec.mapper;

import com.example.sec.dto.CarDTO;
import com.example.sec.model.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface carMapper {

    CarDTO toCarDTO(Car car);

    Car toCar(CarDTO carDTO);

    List<CarDTO> toCarDTOList(List<Car> list);

    List<Car> toCarList(List<CarDTO> carDTOList);
}
