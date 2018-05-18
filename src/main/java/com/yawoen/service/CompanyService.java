package com.yawoen.service;

import java.util.List;

import com.yawoen.domain.CompanyDO;

public interface CompanyService {
	
	void update();
	void delete(Long id);
	void create(CompanyDO companyDO);
	void create (List<CompanyDO> companies);

}
