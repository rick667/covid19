package com.planisa.testecovid;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Covid19Service {
  private final HttpClient httpClient;
  
  public Covid19Service(HttpClient httpClient) {
    this.httpClient = httpClient;
  }
  
  public List<Country> getCountries() throws IOException, InterruptedException {
	  CloseableHttpClient client = HttpClientBuilder.create().build();
	  HttpGet request = new HttpGet("https://api.covid19api.com/countries");
	  CloseableHttpResponse response = client.execute(request);

	  // Deserialize the JSON response into a list of Country objects
	  ObjectMapper objectMapper = new ObjectMapper();
	  return objectMapper.readValue(EntityUtils.toString(response.getEntity()), new TypeReference<List<Country>>() {});
  }
  
  public Comparison getComparison(String country1, String country2, String dateInit, String dateFinal) throws IOException, InterruptedException {
	  CloseableHttpClient client = HttpClientBuilder.create().build();
	  HttpGet request = new HttpGet(String.format("https://api.covid19api.com/compare/%s/%s/%s/%s", country1, country2, dateInit, dateFinal));
	  CloseableHttpResponse response = client.execute(request);

	  // Deserialize the JSON response into a Comparison object
	  ObjectMapper objectMapper = new ObjectMapper();
	  return objectMapper.readValue(EntityUtils.toString(response.getEntity()), Comparison.class);
  }
}

