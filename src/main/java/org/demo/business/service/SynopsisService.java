/*
 * Created on 3 avr. 2014 ( Time 19:39:50 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.Synopsis;

/**
 * Business Service Interface for entity Synopsis.
 */
public interface SynopsisService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param bookId
	 * @return entity
	 */
	Synopsis findById( Integer bookId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Synopsis> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Synopsis save(Synopsis entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Synopsis update(Synopsis entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Synopsis create(Synopsis entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param bookId
	 */
	void delete( Integer bookId );


}
