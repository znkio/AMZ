package com.io.znk.ctalin.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.io.znk.ctalin.model.jpa.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company>{

	
	public List<Company> findAll();
	
	public Company findByTitle(String title);
	
	@SuppressWarnings("unchecked")
	public Company save(Company company);
	
	public Company findByCompanyId(Long id);
	
	public void delete(Company company);
	
	
	
	@Query("from Company c where c.companyId=?")
	public Company getByCompanyId(Long id);
	

	
	//@Query("from Company c left join fetch UGroups ug where UGroups.title=?")
	//public Company getByUGroupsTitle(String title);
}
