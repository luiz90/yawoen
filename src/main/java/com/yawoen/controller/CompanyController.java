package com.yawoen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yawoen.controller.mapper.CompanyMapper;
import com.yawoen.domain.CompanyDO;
import com.yawoen.dto.CompanyDTO;
import com.yawoen.service.CompanyService;

@RestController
@RequestMapping("v1/companies")
public class CompanyController {
	
	private final CompanyService companyService;
	
	@Autowired
	public CompanyController(final CompanyService companyService)
	{
		this.companyService = companyService;
	}
	
	@GetMapping
	public List<CompanyDTO> getCompanies()
	{
		return CompanyMapper.makeCompanyDTOList(companyService.findAll());
	}
	
	@GetMapping("/{companyId}")
	public CompanyDTO getCompany(@Valid @PathVariable long companyId) {
		return CompanyMapper.makeCompanyDTO(companyService.find(companyId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CompanyDTO createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
		CompanyDO companyDO = CompanyMapper.makeCompanyDO(companyDTO);
		return CompanyMapper.makeCompanyDTO(companyService.create(companyDO));
	}
	
	@DeleteMapping("/{companyId}")
	public void deleteCompany(@Valid @PathVariable long companyId) {
		this.companyService.delete(companyId);
	}
	
	@PutMapping("/{companyId}")
	public void updateCompany(@Valid @PathVariable long companyId, @RequestBody CompanyDTO companyDTO) {
		CompanyDO companyDO = CompanyMapper.makeCompanyDO(companyDTO);
		this.companyService.update(companyDO, companyId);
	}

}
