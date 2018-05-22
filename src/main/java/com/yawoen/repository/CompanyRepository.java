package com.yawoen.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yawoen.domain.CompanyDO;

@Repository
public interface CompanyRepository extends MongoRepository<CompanyDO, Long> {

	public CompanyDO findByName(String name);
	
	public List<CompanyDO> findByNameContainingAndZipCode(String name, String zipCode);
}
