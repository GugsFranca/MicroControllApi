package com.micro.parkingapi.service;


import com.micro.parkingapi.model.CarModel;
import com.micro.parkingapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public CarModel save(CarModel carModel){
        return carRepository.save(carModel);
    }
    public void delete(UUID id){
        carRepository.deleteById(id);
    }
}




