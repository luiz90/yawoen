package com.yawoen.service;

import java.util.List;

import com.yawoen.domain.CompanyDO;

public interface CompanyService {
	
	CompanyDO find(long id);
	List<CompanyDO> findAll();
	void update(CompanyDO companyDO, long id);
	void delete(Long id);
	CompanyDO create(CompanyDO companyDO);
	void create(List<CompanyDO> companies);

}
