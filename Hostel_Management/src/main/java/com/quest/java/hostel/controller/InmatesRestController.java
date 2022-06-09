package com.quest.java.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.java.hostel.dao.InmateDAO;
import com.quest.java.hostel.entity.Inmate;
import com.quest.java.hostel.entity.Room;

@RestController
@RequestMapping("/")
public class InmatesRestController {
	
	private InmateDAO inmateDAO;

	@Autowired
	public InmatesRestController(InmateDAO inmateDAO) {
		this.inmateDAO = inmateDAO;
	}
	
	@PostMapping("inmate")
	public Inmate addInmate(@RequestBody Inmate inmate){
		inmate.setId(0);
		inmateDAO.save(inmate);
		return inmate;
	}
	
	@PutMapping("inmate")
	public Inmate updateInmate(@RequestBody Inmate inmate){
		
		inmateDAO.save(inmate);
		return inmate;
	}

	@GetMapping("inmate/{theId}")
	public Inmate findById(@PathVariable int theId){
		Inmate inmate= inmateDAO.detailsById(theId);
		return inmate;
	}
	
	@GetMapping("room/{roomNo}")
	public Room findByRoom(@PathVariable int roomNo){
		Room room = inmateDAO.detailsByRoom(roomNo);
		return room;
	}
	
	@DeleteMapping("delete/{theId}")
	public String deleteById(@PathVariable int theId){
		
		Inmate inmate = inmateDAO.detailsById(theId);
		
		if(inmate==null){
			throw new RuntimeException("User not found");
		}
		inmateDAO.delete(theId);
		return "inmate with Id "+theId+" is deleted";
	}
}
