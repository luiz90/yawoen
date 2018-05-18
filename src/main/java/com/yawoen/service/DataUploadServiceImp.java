package com.yawoen.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.yawoen.component.CsvDataLoader;
import com.yawoen.domain.CompanyDO;

@Service
public class DataUploadServiceImp implements DataUploadService {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CsvDataLoader dataLoader;

	@Override
	@Transactional
	@EventListener(ApplicationReadyEvent.class)
	public void loadCompanyDataOnStartup() throws IOException {
		File file = new ClassPathResource("q1_catalog.csv").getFile();
		List<CompanyDO> loadObjectList = dataLoader.loadObjectList(file);
		this.companyService.create(loadObjectList);
	}

}
