package com.wellshang.demo.service;

import com.wellshang.demo.domain.User;
import com.wellshang.demo.domain.UserRole;
import com.wellshang.demo.repository.RoleDao;
import com.wellshang.demo.repository.UserDao;
import com.wellshang.demo.repository.UserRoleDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {

    	logger.debug("Authenticating ", username);

        User user = userDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        List<UserRole> userRoles = userRoleDao.listByUserId(user.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : userRoles) {
        	String roleName = roleDao.findOne(userRole.getRoleId()).getRolename();
        	authorities.add(new SimpleGrantedAuthority(roleName));
            logger.debug("username is " + username + ", " + roleName);
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }

}
