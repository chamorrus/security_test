package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Default CRUD repository.
 * 
 * @author chamorrus
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
