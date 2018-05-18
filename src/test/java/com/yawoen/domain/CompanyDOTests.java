package com.yawoen.domain;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.Entity;

import org.junit.Assert;
import org.junit.Before;
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
	}

	@Test
	public void typeAnnotations() {
		AssertAnnotations.assertType(CompanyDO.class);
	}

	@Test
	public void fieldAnnotations() {
		AssertAnnotations.assertField(CompanyDO.class, "id");
		AssertAnnotations.assertField(CompanyDO.class, "name");
		AssertAnnotations.assertField(CompanyDO.class, "zipCode");
		AssertAnnotations.assertField(CompanyDO.class, "website");
	}

	@Test
	public void entity() {
		Entity a = ReflectTool.getClassAnnotation(CompanyDO.class, Entity.class);
		Assert.assertEquals("", a.name());
	}

	@Test
	public void checkObjectAfterSave() {
		CompanyDO companyDO = this.repository.findByName("COMPANY");
		assertThat(companyDO.getId()).isGreaterThan(1);
		assertThat(companyDO.getName()).isEqualTo("COMPANY");
		assertThat(companyDO.getWebsite()).isEqualTo("http://site.com");
	}

}
