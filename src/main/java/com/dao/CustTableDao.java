package com.dao;
import java.sql.CallableStatement;
import java.sql.SQLException;
//import java.sql.SQLType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



import com.util.HibernateUtil;
import com.model.CustTable;
@Repository
public class CustTableDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public void saveOrUpdate(CustTable custTable){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(custTable);
		session.getTransaction().commit();
		session.close();
	}
	public void delete(CustTable custTable){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(custTable);
		session.getTransaction().commit();
		session.close();
	}
	public void delete(List<CustTable> custTableList) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for (CustTable custTable : custTableList) {
			session.delete(custTable);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateByStoredProcedure(String custAccount) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<CustTable> list = session.createCriteria(CustTable.class).add(Restrictions.eq("custAccount", custAccount)).list();
		session.getNamedQuery("InsertCustomer_SP").setParameter("CustAccount", custAccount).executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<CustTable> getCustomerById(String custAccount) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<CustTable> list = session.createCriteria(CustTable.class).add(Restrictions.eq("custAccount", custAccount)).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	public List<CustTable> getAllCustomer(){
		//Session session = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CustTable> list = session.getNamedQuery("selectAllCustomer_SP").list();
		//List<CustTable> list = session.createQuery("from CustTable").list();
		session.close();
		return list;
	}
}
