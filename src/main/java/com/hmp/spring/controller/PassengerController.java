
/*
 * Copyright (c) 2022 : 2/27/22, 5:52 PM
 * Last Modified: 2/27/22, 5:39 PM
 * All Rights Reserved: hobject
 *
 *
 */

package com.hmp.spring.controller;

import javax.transaction.Transactional;

import com.hmp.spring.RequestDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.hmp.spring.dao.PassengerRepository;
import com.hmp.spring.model.Passenger;
import com.hmp.spring.service.PassengerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
@RequestMapping("/")
public class PassengerController {
	private final PassengerRepository passengerRepository;
	private final Passenger passenger;
	private final PassengerService passengerService;
	@Autowired
	public PassengerController(PassengerRepository passengerRepository, Passenger passenger, PassengerService passengerService) {
		this.passengerRepository = passengerRepository;
		this.passenger = passenger;
		this.passengerService = passengerService;
	}

	@RequestMapping("/start")
	public  ModelAndView getForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@PostMapping("/addData")
	public String postData(@RequestParam String fname, @RequestParam String lname, @RequestParam String email, @RequestParam String phone, @RequestParam String deleted) {
		passenger.setFirstName(fname);
		passenger.setLastName(lname);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		passenger.setDeleted(deleted);
		passengerRepository.save(passenger);
		return "Successfully saved!";
	}
@GetMapping("/find")
public ModelAndView getAllInfo(Pageable pageable) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("find");

	 return mv;
	
}
	@GetMapping("/findAll")
	public Page<Passenger> getAll(Pageable pageable) {
	return passengerService.pageByALl(pageable);
}
	@GetMapping("/bulkDelete")

	public void bulkDeleteAll(@RequestBody RequestDto requestDto) {
		if (requestDto!=null ) {
			//selected true --> ids --[1,2,3] --> delete items
			try{
			if (requestDto.getSelected()) {
				if (!CollectionUtils.isEmpty(requestDto.getIds())) {
					List<Passenger> passengers = (List<Passenger>) passengerRepository.findAll();
					List<Integer> listOfAllIdsRequest = passengers.stream().map(Passenger::getId).collect(Collectors.toList());
					List<Integer> list = requestDto.getIds();
					listOfAllIdsRequest.removeAll(list);
					List<Integer> idsToDelete = new ArrayList<>(listOfAllIdsRequest);
					passengerService.deleteSoftDelete(idsToDelete);
				} else {
					passengerService.deleteSoftDelete();
				}
			}
			else {
				passengerService.deleteSoftDelete(requestDto.getIds());
			}
		}catch (Exception e){
			e.printStackTrace();
			}
		}
	}
	@GetMapping("/bulkDelete/{id}")
	public void bulkDeleteAll(@PathVariable Integer id) {
		passengerService.deleteSoftDelete(id);
	}
	}
