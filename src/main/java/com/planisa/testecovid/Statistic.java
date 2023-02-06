package com.planisa.testecovid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "covid19")
public class Statistic {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "from", nullable = false)
    private String from;

    @Column(name = "to", nullable = false)
    private String to;

    @Column(name = "confirmed", nullable = false)
    private int confirmed;

    @Column(name = "deaths", nullable = false)
    private int deaths;

    @Column(name = "recovered", nullable = false)
    private int recovered;

    //getters and setters
}
