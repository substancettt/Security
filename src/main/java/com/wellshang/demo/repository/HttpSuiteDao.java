package com.wellshang.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wellshang.demo.domain.HttpSuite;

public interface HttpSuiteDao extends CrudRepository<HttpSuite, Integer> {
	List<HttpSuite> findAll();

	@SuppressWarnings("unchecked")
	HttpSuite save(HttpSuite t);

	HttpSuite findOne(Integer id);
}
