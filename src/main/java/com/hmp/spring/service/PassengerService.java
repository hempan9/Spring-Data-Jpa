package com.hmp.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hmp.spring.dao.PassengerRepository;
import com.hmp.spring.model.Passenger;

@Service
public class PassengerService {
	@Autowired
	PassengerRepository repository;
	

}
