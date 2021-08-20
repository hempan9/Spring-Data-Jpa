package com.hmp.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hmp.spring.dao.PassengerRepository;
import com.hmp.spring.model.Passenger;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PassengerService {
	@Autowired
	PassengerRepository repository;
	//Crud repo has default two methods deleteById nad deleteAll()
	public String deleteById(Integer id){
		repository.deleteById(id);
		return "Successfully Deleted.";
	}
	//delete by first name
	public Iterable<Passenger> deleteByFirstName(String fname){
		return repository.deleteByFirstName(fname);
	}

}
