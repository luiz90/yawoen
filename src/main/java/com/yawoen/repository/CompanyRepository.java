package com.yawoen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yawoen.domain.CompanyDO;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDO, Long> {

}
