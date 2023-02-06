package com.planisa.testecovid;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryDataService {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void saveCountryData(String country, LocalDate dateInit, LocalDate dateFinal, int cases, int deaths, int recovered) {
    CountryData countryData = findByCountry(country);
    if (countryData == null) {
      countryData = new CountryData();
      countryData.setCountry(country);
      countryData.setDateInit(dateInit);
      countryData.setDateFinal(dateFinal);
      countryData.setCases(cases);
      countryData.setDeaths(deaths);
      countryData.setRecovered(recovered);
      entityManager.persist(countryData);
    } else {
      if (countryData.getDateInit().isAfter(dateInit) || countryData.getDateFinal().isBefore(dateFinal)) {
        countryData.setDateInit(dateInit);
        countryData.setDateFinal(dateFinal);
        countryData.setCases(cases);
        countryData.setDeaths(deaths);
        countryData.setRecovered(recovered);
        entityManager.merge(countryData);
      }
    }
  }

  public CountryData findByCountry(String country) {
    try {
      Query query = entityManager.createQuery("SELECT c FROM CountryData c WHERE c.country = :country");
      query.setParameter("country", country);
      return (CountryData) query.getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
