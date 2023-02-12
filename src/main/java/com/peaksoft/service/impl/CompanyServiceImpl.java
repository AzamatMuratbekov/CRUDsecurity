package com.peaksoft.service.impl;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.repository.CompanyRepository;
import com.peaksoft.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Company company1 = companyRepository.getById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        companyRepository.save(company1);
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.delete(company);
    }
    @Override
    public List<Course> getCoursesByCompanyId(Long id) {
        return companyRepository.getCoursesByCompanyId(id);
    }

    @Override
    public Long getStudentsByCompanyId(Long id) {
        return companyRepository.getStudentsByCompanyId(id);
    }

}
