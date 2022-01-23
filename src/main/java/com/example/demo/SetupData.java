package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Custom default data with dvelopment purposes.
 * 
 * @author chamorrus
 *
 */
@Component
public class SetupData {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@PostConstruct
	public void init() {
		initPrivileges();
		initOrganizations();
		initUsers();
	}

	private void initPrivileges() {
		Privilege privilege1 = new Privilege("FOO_READ_PRIVILEGE");
		privilegeRepository.save(privilege1);

		Privilege privilege2 = new Privilege("FOO_WRITE_PRIVILEGE");
		privilegeRepository.save(privilege2);
	}

	private void initOrganizations() {
		Organization org1 = new Organization("FirstOrg");
		organizationRepository.save(org1);

		Organization org2 = new Organization("SecondOrg");
		organizationRepository.save(org2);
	}

	private void initUsers() {
		Privilege privilege1 = privilegeRepository.findByName("FOO_READ_PRIVILEGE");
		Privilege privilege2 = privilegeRepository.findByName("FOO_WRITE_PRIVILEGE");

		User user1 = new User();
		user1.setUsername("john");
		user1.setPassword("123");
		user1.setPrivileges(new HashSet<Privilege>(Arrays.asList(privilege1)));
		user1.setOrganization(organizationRepository.findByName("FirstOrg"));
		userRepository.save(user1);

		User user2 = new User();
		user2.setUsername("tom");
		user2.setPassword("111");
		user2.setPrivileges(new HashSet<Privilege>(Arrays.asList(privilege1, privilege2)));
		user2.setOrganization(organizationRepository.findByName("SecondOrg"));
		userRepository.save(user2);
	}

}