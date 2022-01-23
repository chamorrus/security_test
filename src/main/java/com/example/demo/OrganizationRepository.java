package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Default CRUD repository.
 * 
 * @author chamorrus
 *
 */
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
	public Organization findByName(String name);
}
