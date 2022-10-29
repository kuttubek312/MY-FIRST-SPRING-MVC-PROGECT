package kuttubek.service.impl;

import kuttubek.dao.CompanyDao;
import kuttubek.model.Company;
import kuttubek.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Company saveCompany(Company company) {
        companyDao.saveCompany(company);
        return company;
    }

    @Override
    public void removeCompanyById(Long id) {
        companyDao.removeCompanyById(id);
    }

    @Override
    public Company getById(Long id) {
        return companyDao.getById(id);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public void update(Long id, Company company) {
        companyDao.update(id,company);
    }
}
