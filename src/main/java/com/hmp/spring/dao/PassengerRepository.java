package com.hmp.spring.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.hmp.spring.model.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

}

