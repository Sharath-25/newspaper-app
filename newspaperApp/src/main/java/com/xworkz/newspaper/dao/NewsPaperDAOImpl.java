package com.xworkz.newspaper.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.newspaper.entity.NewsPaperEntity;

@Component
public class NewsPaperDAOImpl implements NewsPaperDAO {

	@Autowired
	private SessionFactory factory;

	public NewsPaperDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Created ");
	}

	@Override
	public boolean saveNewsPaperEntity(NewsPaperEntity newsPaperentity) {
		System.out.println("Invoked saveNewsPaperEntity()");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(newsPaperentity);
			session.getTransaction().commit();
			System.out.println("NewsPaperEntity saved");
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			System.out.println("Transaction is rolled back");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return false;
	}

	@Override
	public NewsPaperEntity getNewsPaperEntity(String newsPaperName) {
		System.out.println("Invoked getNewsPaperEntity()");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("NewsPaperEntity.getnewsPaperObject");
			query.setParameter("name", newsPaperName);
			NewsPaperEntity entity = (NewsPaperEntity) query.uniqueResult();
			System.out.println("found newsPaperName" + entity);
			if (entity != null) {
				return entity;
			} else {
				System.out.println("newsPaperName not found");
				return null;
			}
		} catch (HibernateException e) {
			System.out.println("inside catch block");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return null;

	}

}
