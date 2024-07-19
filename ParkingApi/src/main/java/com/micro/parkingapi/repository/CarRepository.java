package com.micro.parkingapi.repository;

import com.micro.parkingapi.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarModel, UUID> {
    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsById(UUID id);

}
