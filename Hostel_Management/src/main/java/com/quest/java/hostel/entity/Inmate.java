package com.quest.java.hostel.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name= "register")
public class Inmate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	@Column(name="name")
	private String name;
	@Column(name="contact")
	private BigInteger contact;
	@Column(name="govId")
	private String govId;
	@OneToOne
	private Room roomNo;
	
	
	public Inmate() {

	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigInteger getContact() {
		return contact;
	}


	public void setContact(BigInteger contact) {
		this.contact = contact;
	}


	public String getGovId() {
		return govId;
	}


	public void setGovId(String govId) {
		this.govId = govId;
	}


	public Room getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(Room roomNo) {
		this.roomNo = roomNo;
	}


	public Inmate(int id, String name, BigInteger contact, String govId, Room roomNo) {
		super();
		Id = id;
		this.name = name;
		this.contact = contact;
		this.govId = govId;
		this.roomNo = roomNo;
	}
	
	

}
