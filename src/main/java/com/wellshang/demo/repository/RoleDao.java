package com.wellshang.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wellshang.demo.domain.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {

    Role findOne(Integer id);
    
    List<Role> findAll();
    
    @SuppressWarnings("unchecked")
    Role save(Role u);

}