package com.wellshang.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellshang.demo.domain.Role;
import com.wellshang.demo.domain.User;
import com.wellshang.demo.domain.UserRole;
import com.wellshang.demo.repository.RoleDao;
import com.wellshang.demo.repository.UserDao;
import com.wellshang.demo.repository.UserRoleDao;

@Service("dataInit")
public class DataInitService {

	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@PostConstruct
	void dataInit() {
		User admin = new User();
		User jack = new User();

		admin.setUsername("admin");
		admin.setPassword("admin");

		jack.setUsername("jack");
		jack.setPassword("123456");

		userDao.save(admin);
		userDao.save(jack);

		Role adminRole = new Role();
		Role userRole = new Role();
		adminRole.setRolename("ROLE_ADMIN");
		userRole.setRolename("ROLE_USER");

		roleDao.save(adminRole);
		roleDao.save(userRole);

		UserRole userRoleAdminRecord = new UserRole();
		userRoleAdminRecord.setUserId(admin.getId());
		userRoleAdminRecord.setRoleId(adminRole.getId());
		userRoleDao.save(userRoleAdminRecord);

		UserRole userRoleJackRecord = new UserRole();
		userRoleJackRecord.setUserId(jack.getId());
		userRoleJackRecord.setRoleId(userRole.getId());
		userRoleDao.save(userRoleJackRecord);

	}
}
