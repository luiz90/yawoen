package com.yawoen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yawoen.domain.CompanyDO;
import com.yawoen.exception.EntityNotFoundException;
import com.yawoen.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public void delete(Long id) {
		this.companyRepository.delete(findCompanyChecked(id));
	}

	@Override
	public CompanyDO create(CompanyDO companyDO) {
		return companyRepository.save(companyDO);
		
	}

	@Override
	public void create(List<CompanyDO> companies) {
		this.companyRepository.saveAll(companies);
	}

	@Override
	public CompanyDO find(long id) {
		return findCompanyChecked(id);
	}
	
	private CompanyDO findCompanyChecked(Long companyId) throws EntityNotFoundException
    {
        return companyRepository
            .findById(companyId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + companyId));
    }

	@Override
	public void update(CompanyDO companyDO, long id) {
		
		CompanyDO companyToUpdate = findCompanyChecked(id);
		
		if (companyDO.getZipCode() != null && !companyDO.getZipCode().equals(""))
			companyToUpdate.setZipCode(companyDO.getZipCode());

		if (companyDO.getWebsite() != null && !companyDO.getWebsite().equals(""))
			companyToUpdate.setWebsite(companyDO.getWebsite());
		
		if (companyDO.getName() != null && !companyDO.getName().equals(""))
			companyToUpdate.setName(companyDO.getName());
		
		companyRepository.save(companyToUpdate);
		
	}

	@Override
	public List<CompanyDO> findAll() {
		
		return this.companyRepository.findAll();
	}

	@Override
	public List<CompanyDO> find(String name, String zipCode) {
		return this.companyRepository.findByNameContainingAndZipCode(name, zipCode);
	}
}
