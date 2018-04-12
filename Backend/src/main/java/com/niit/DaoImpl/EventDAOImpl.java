package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.EventDAO;
import com.niit.model.Event;



@Repository("EventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
  
	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}  
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Event> list() {
		List<Event> listEvent = sessionFactory.getCurrentSession().createQuery("from Event").list();
		return listEvent;
	}

	@Transactional
	public void saveOrUpdate(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
   }

	
	@Transactional
	public void delete(int eventid) {
		Event eventToDelete = new Event();
		eventToDelete.setEventid(eventid);
		sessionFactory.getCurrentSession().delete(eventToDelete);
		
	}

	@Transactional
	public Event getByEventcategory(String eventcategory) {
		Event Eventcategory = (Event) sessionFactory.getCurrentSession().get(Event.class, eventcategory);
		return Eventcategory;
	}

	@Transactional
	public Event getByEventid(int eventid) {
		Event Eventid = (Event) sessionFactory.getCurrentSession().get(Event.class, eventid);
		return Eventid;
	}

	@Transactional
   public void insert(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		
	}

}