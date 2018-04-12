package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.CustTableDao;
import com.model.CustTable;
@Service
public class CustomerService {
	private CustTableDao custTableDao;
	public void setCustTableDao(CustTableDao custTableDao) {
		this.custTableDao = custTableDao;
	}
	public List<CustTable> listAllCustomers(){
		CustTableDao custTableDao = new CustTableDao();
		return custTableDao.getAllCustomer();
	}
	public List<CustTable> getCustomerById(String custAccount) {
		CustTableDao custTableDao = new CustTableDao();
		return custTableDao.getCustomerById(custAccount);
	}
	public void saveOrUpdateCustomer(CustTable custTable) {
		CustTableDao custTableDao = new CustTableDao();
		custTable.setCreatedDate(new Date());
		custTableDao.saveOrUpdate(custTable);
	}
	public void deleteCustomer(CustTable custTable) {
		CustTableDao custTableDao = new CustTableDao();
		custTableDao.delete(custTable);
	}
}
