package com.quest.java.hostel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quest.java.hostel.entity.Inmate;
import com.quest.java.hostel.entity.Room;

@Repository
public class InmateDAOImpl implements InmateDAO {

	private EntityManager entitymanager;

	@Autowired
	public  InmateDAOImpl(EntityManager entityManager) {
		this.entitymanager = entityManager;
	}

	@Override
	@Transactional
	public void save(Inmate inmate) {
		
		Session currentsession = entitymanager.unwrap(Session.class);
		currentsession.saveOrUpdate(inmate);

	}

	@Override
	@Transactional
	public List<Inmate> inmateDetails() {
		
		Session currentsession = entitymanager.unwrap(Session.class);
		Query<Inmate> query = currentsession.createQuery("from Inmate");
		List<Inmate> inmate = query.getResultList();
		return inmate;
	}

	@Override
	@Transactional
	public Inmate detailsById(int theId) {
		
		Session currentsession = entitymanager.unwrap(Session.class);
		Inmate inmate = currentsession.get(Inmate.class, theId);
		
		return inmate;
	}

	@Override
	@Transactional
	public Room detailsByRoom(int roomNo) {
		
		Session currentsession = entitymanager.unwrap(Session.class);
		Room room = currentsession.get(Room.class, roomNo);
		
		return room;
	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		Session currentsession = entitymanager.unwrap(Session.class);
		Query query = currentsession.createQuery("delete from Inmate where id = :inmateId");
		query.setParameter("inmateId", theId);
		query.executeUpdate();

	}

}
