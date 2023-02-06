package com.planisa.testecovid;

import java.util.List;

public interface CountryDataRepository {

  List<CountryData> findAll();

  void save(CountryData countryData);

  CountryData findById(String slug);

Covid19Data findByCountry(String country);
}
