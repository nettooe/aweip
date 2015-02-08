package com.aweip.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The Class AweipDAO.
 */
public abstract class AweipDAO {

	/** EntityManager default. */
	@PersistenceContext
	protected EntityManager entityManager;

}
