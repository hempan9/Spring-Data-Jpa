package com.hmp.spring.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.hmp.spring.dao.PassengerRepository;
import com.hmp.spring.model.Passenger;
import com.hmp.spring.service.PassengerService;

@RestController
@Transactional
@RequestMapping("/")
public class PassengerController {
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private Passenger passenger;
	@Autowired
	private PassengerService passengerService;
	@RequestMapping("/")
	public  ModelAndView getForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@PostMapping("/addData")
	public String postData(@RequestParam String fname, @RequestParam String lname,
			@RequestParam String email, @RequestParam String phone) {
		passenger.setFirstName(fname);
		passenger.setLastName(lname);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		passengerRepository.save(passenger);
		return "Successfully saved!";
	}
@GetMapping("/find")
public Iterable<Passenger> getAllInfo() {

	return passengerRepository.findAll();
	
}
@DeleteMapping("/deletebyid")
	public String delete(@RequestParam("idNum") Integer id){
		return passengerService.deleteById(id);
}
@DeleteMapping("/deletebyname")
	public Iterable<Passenger> deleteByFirstname(@RequestParam("fname") String firstname ){
		return passengerService.deleteByFirstName(firstname);
}
}
