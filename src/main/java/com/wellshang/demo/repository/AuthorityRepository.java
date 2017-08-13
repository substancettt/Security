package com.wellshang.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wellshang.demo.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
