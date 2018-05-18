package com.yawoen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yawoen.domain.CompanyDO;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDO, Long> {

	public CompanyDO findByName(String name);
	
	public List<CompanyDO> findByNameContainingAndZipCode(String name, String zipCode);
}
