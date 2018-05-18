package com.yawoen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yawoen.domain.CompanyDO;
import com.yawoen.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(CompanyDO companyDO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(List<CompanyDO> companies) {
		this.companyRepository.saveAll(companies);
	}
	
}
