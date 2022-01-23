package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Default CRUD repository.
 * 
 * @author chamorrus
 *
 */
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
	public Privilege findByName(String name);
}
