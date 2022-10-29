package kuttubek.dao.impl;

import kuttubek.dao.CompanyDao;
import kuttubek.model.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company saveCompany(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public void removeCompanyById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Company getById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void update(Long id, Company company) {
        Company company1=getById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
    }
}
