package com.planisa.testecovid;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TesteCovidApplication {
	  public static void main(String[] args) {
	    try {
	      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19?createDatabaseIfNotExist=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "planisa", "859199711Ri@");
	      java.sql.Statement statement = connection.createStatement();
	      String checkTable = "SHOW TABLES LIKE 'covid19'";
	      if (!statement.executeQuery(checkTable).next()) {
	        String createTable = "CREATE TABLE covid19 (dateInit VARCHAR(255), dateFinal VARCHAR(255), country VARCHAR(255), slug VARCHAR(255), confirmed INT, deaths INT, recuperated INT, PRIMARY KEY (country, dateInit))";
	        statement.executeUpdate(createTable);
	        System.out.println("deu certo");
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      System.out.println("deu errado");
	    }
	    
	    String workingDirectory = "C:/Users/Richard/OneDrive/Área de Trabalho/Work/teste-covid/src/main/frontend/client/src/main.jsx";
	    CommandLine cmLineFront = new CommandLine("yarn dev");
	    DefaultExecutor executorFront = new DefaultExecutor();
	    executorFront.setWorkingDirectory(new File(workingDirectory));
	    executorFront.setExitValue(1);
	    try {
	      int exitValue = executorFront.execute(cmLineFront);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    CommandLine cmdLine = new CommandLine("python");
	    cmdLine.addArgument("C:/Users/Richard/OneDrive/Área de Trabalho/Work/teste-covid/src/main/backend/python/covid_api.py");
	    DefaultExecutor executor = new DefaultExecutor();
	    executor.setExitValue(0);
	    try {
	      int exitValue = executor.execute(cmdLine);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
