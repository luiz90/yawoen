package com.yawoen.domain;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.Entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yawoen.repository.CompanyRepository;
import com.yawoen.util.AssertAnnotations;
import com.yawoen.util.ReflectTool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDOTests {

	@Autowired
	private CompanyRepository repository;

	@Before
	public void setup() {
		this.repository.save(new CompanyDO("COMPANY", "11111", "http://site.com"));
		this.repository.save(new CompanyDO("COOLCOMPANY", "11111", "http://site.com"));
	}

	@Test
	@Ignore
	public void typeAnnotations() {
		AssertAnnotations.assertType(CompanyDO.class);
	}

	@Test
	@Ignore
	public void fieldAnnotations() {
		AssertAnnotations.assertField(CompanyDO.class, "id");
		AssertAnnotations.assertField(CompanyDO.class, "name");
		AssertAnnotations.assertField(CompanyDO.class, "zipCode");
		AssertAnnotations.assertField(CompanyDO.class, "website");
	}

	@Test
	@Ignore
	public void entity() {
		Entity a = ReflectTool.getClassAnnotation(CompanyDO.class, Entity.class);
		Assert.assertEquals("", a.name());
	}

	@Test
	public void checkObjectAfterSave() {
		CompanyDO companyDO = this.repository.findByName("COMPANY");
		//assertThat(companyDO.getId()).isGreaterThan(1);
		assertThat(companyDO.getName()).isEqualTo("COMPANY");
		assertThat(companyDO.getWebsite()).isEqualTo("http://site.com");
	}
	
	@Test
	public void checkObjectAfterUpdate() {
		CompanyDO companyDO = this.repository.findByName("COMPANY2");
		companyDO.setWebsite("no-site");
		this.repository.save(companyDO);
		
		CompanyDO company = this.repository.findByName("COMPANY");
		assertThat(company.getWebsite()).isEqualTo("no-site");
	}

}
