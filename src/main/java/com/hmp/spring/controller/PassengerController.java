package com.hmp.spring.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hmp.spring.dao.PassengerRepository;
import com.hmp.spring.model.Passenger;
import com.hmp.spring.service.PassengerService;

@RestController
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

}
