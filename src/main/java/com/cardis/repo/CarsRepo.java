package com.cardis.repo;

import com.cardis.model.Cars;
import com.cardis.model.enums.BodyType;
import com.cardis.model.enums.CarStatus;
import com.cardis.model.enums.Fuel;
import com.cardis.model.enums.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepo extends JpaRepository<Cars, Long> {
    List<Cars> findAllByStatus(CarStatus status);

    List<Cars> findAllByStatusAndDescription_BodyTypeAndDescription_TransmissionAndDescription_Fuel(CarStatus status, BodyType bodyType, Transmission transmission, Fuel fuel);
}
