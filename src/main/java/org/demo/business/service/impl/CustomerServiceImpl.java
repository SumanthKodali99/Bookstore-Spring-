/*
 * Created on 3 avr. 2014 ( Time 19:39:42 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.Customer;
import org.demo.bean.jpa.CustomerEntity;
import java.util.List;
import org.demo.business.service.CustomerService;
import org.demo.business.service.mapping.CustomerServiceMapper;
import org.demo.data.repository.jpa.CustomerJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of CustomerService
 */
@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerJpaRepository customerJpaRepository;

	@Resource
	private CustomerServiceMapper customerServiceMapper;
	
	@Override
	public Customer findById(String code) {
		CustomerEntity customerEntity = customerJpaRepository.findOne(code);
		return customerServiceMapper.mapCustomerEntityToCustomer(customerEntity);
	}

	@Override
	public List<Customer> findAll() {
		Iterable<CustomerEntity> entities = customerJpaRepository.findAll();
		List<Customer> beans = new ArrayList<Customer>();
		for(CustomerEntity customerEntity : entities) {
			beans.add(customerServiceMapper.mapCustomerEntityToCustomer(customerEntity));
		}
		return beans;
	}

	@Override
	public Customer save(Customer customer) {
		return update(customer) ;
	}

	@Override
	public Customer create(Customer customer) {
		CustomerEntity customerEntity = customerJpaRepository.findOne(customer.getCode());
		if( customerEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		customerEntity = new CustomerEntity();
		customerServiceMapper.mapCustomerToCustomerEntity(customer, customerEntity);
		CustomerEntity customerEntitySaved = customerJpaRepository.save(customerEntity);
		return customerServiceMapper.mapCustomerEntityToCustomer(customerEntitySaved);
	}

	@Override
	public Customer update(Customer customer) {
		CustomerEntity customerEntity = customerJpaRepository.findOne(customer.getCode());
		customerServiceMapper.mapCustomerToCustomerEntity(customer, customerEntity);
		CustomerEntity customerEntitySaved = customerJpaRepository.save(customerEntity);
		return customerServiceMapper.mapCustomerEntityToCustomer(customerEntitySaved);
	}

	@Override
	public void delete(String code) {
		customerJpaRepository.delete(code);
	}

	public CustomerJpaRepository getCustomerJpaRepository() {
		return customerJpaRepository;
	}

	public void setCustomerJpaRepository(CustomerJpaRepository customerJpaRepository) {
		this.customerJpaRepository = customerJpaRepository;
	}

	public CustomerServiceMapper getCustomerServiceMapper() {
		return customerServiceMapper;
	}

	public void setCustomerServiceMapper(CustomerServiceMapper customerServiceMapper) {
		this.customerServiceMapper = customerServiceMapper;
	}

}