package com.planisa.testecovid;


import org.springframework.stereotype.Repository;

import com.planisa.testecovid.CountryData;
import com.planisa.testecovid.CountryDataRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CountryDataRepositoryImpl implements CountryDataRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<CountryData> findAll() {
    TypedQuery<CountryData> query = entityManager.createQuery("SELECT c FROM CountryData c", CountryData.class);
    return query.getResultList();
  }

  @Override
  @Transactional
  public void save(CountryData countryData) {
    entityManager.persist(countryData);
  }

  @Override
  public CountryData findById(String slug) {
    return entityManager.find(CountryData.class, slug);
  }

@Override
public Covid19Data findByCountry(String country) {
	// TODO Auto-generated method stub
	return null;
}
}
