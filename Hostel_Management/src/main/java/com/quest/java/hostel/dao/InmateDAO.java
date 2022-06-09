package com.quest.java.hostel.dao;

import java.util.List;

import com.quest.java.hostel.entity.Inmate;
import com.quest.java.hostel.entity.Room;

public interface InmateDAO {

public void save(Inmate inmate);
	
	public List<Inmate> inmateDetails();
	
	public Inmate detailsById(int theId);
	
	public Room detailsByRoom(int roomNo);
	
	public void delete(int theId);
	
}
