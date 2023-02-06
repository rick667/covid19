package com.planisa.testecovid;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Covid19DAO {
	private JdbcTemplate jdbcTemplate;
	public Covid19DAO(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Covid19Data covid19Data) {
	    String sql = "INSERT INTO covid19 (country, confirmed, deaths, recovered) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(sql, covid19Data.getCountry(), covid19Data.getConfirmed(), covid19Data.getDeaths(), covid19Data.getRecupered());
	}
}