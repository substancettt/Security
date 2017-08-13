package com.wellshang.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wellshang.demo.domain.User;

public interface UserDao extends CrudRepository<User, Integer> {

	@Query(value = "select * from `user` where `username` = ?1 limit 1", nativeQuery = true)
    User getUserByUsername(@Param("username") String username);

    User findByUsername(String username);

    User findOne(Integer id);
    @SuppressWarnings("unchecked")
	User save(User u);
    List<User> findAll();


}