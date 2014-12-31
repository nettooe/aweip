package com.aweip.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AweipDAO {

	/**
	 * EntityManager default
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	


}
