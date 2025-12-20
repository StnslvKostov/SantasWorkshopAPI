package com.swapi.exam.repository;

import com.swapi.exam.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
