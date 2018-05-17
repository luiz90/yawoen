package com.yawoen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yawoen.repository.CompanyRepository;

@Service
public class DataUploadServiceImp implements DataUploadService {

	@Autowired
	private CompanyService companyService;

	@Override
	public void loadCompanyDataOnStartup() {
		// TODO Auto-generated method stub
		
	}

}
