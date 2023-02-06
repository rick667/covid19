package com.planisa.testecovid;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CovidDataRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CountryDataRepository covidDataRepository;

    @Test
    public void testFindByCountry() {
        // Given
        Covid19Data covidData = new Covid19Data("2021-01-01", "2021-01-02", "Brazil", "brazil", 100, 10, 90);
        entityManager.persist(covidData);
        entityManager.flush();

        // When
        Covid19Data found = covidDataRepository.findByCountry("Brazil");

        // Then
        assertThat(found.getCountry()).isEqualTo("Brazil");
    }

}
