package com.yawoen.component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.yawoen.domain.CompanyDO;

@Component
public class CsvDataLoader {

	public List<CompanyDO> loadObjectList(File file) throws IOException {
		return new BufferedReader(new FileReader(file)).lines().skip(1).map(s -> {
			String[] row = s.split(";");
			CompanyDO companyDO = new CompanyDO(row[0].toUpperCase());
			if (row.length > 1)
				companyDO.setZipCode(row[1]);
			return companyDO;
		}).collect(Collectors.toList());
	}

}
