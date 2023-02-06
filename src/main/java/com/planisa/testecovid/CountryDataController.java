package com.planisa.testecovid;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country-data")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CountryDataController {

  private final CountryDataService countryDataService;

  public CountryDataController(CountryDataService countryDataService) {
    this.countryDataService = countryDataService;
  }

  @PostMapping
  public void saveCountryData(
    @RequestParam String country,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateInit,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFinal,
    @RequestParam int cases,
    @RequestParam int deaths,
    @RequestParam int recovered
  ) {
    countryDataService.saveCountryData( country, dateInit, dateFinal, cases, deaths, recovered);
  }
}