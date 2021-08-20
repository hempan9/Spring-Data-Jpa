package com.hmp.spring.dao;
import org.springframework.data.repository.CrudRepository;

import com.hmp.spring.model.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
    public Iterable<Passenger> deleteByFirstName(String firstName);

}

