package com.wellshang.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wellshang.demo.domain.UserRole;

public interface UserRoleDao extends CrudRepository<UserRole, Integer> {
	
    List<UserRole> findAll();

    @SuppressWarnings("unchecked")
    UserRole save(UserRole u);
    
    UserRole findOne(Integer id);

	@Query(value = "SELECT * FROM user_role where user_id = ?1", nativeQuery = true)
    List<UserRole> listByUserId(@Param("userId") Integer userId);
}