package com.planisa.testecovid;

public class Covid19Data {


    private String dateInit;
    private String dateFinal;
    private String country;
    private String slug;
    private int confirmed;
    private int deaths;
    private int recupered;
    
    public Covid19Data() {
    }

    public Covid19Data(String dateInit, String dateFinal, String country, String slug, int confirmed, int deaths, int recupered) {
        this.dateInit = dateInit;
        this.dateFinal = dateFinal;
        this.country = country;
        this.slug = slug;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recupered = recupered;
    }

	public String getDateInit() {
		return dateInit;
	}

	public void setDateInit(String dateInit) {
		this.dateInit = dateInit;
	}

	public String getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(String dateFinal) {
		this.dateFinal = dateFinal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getRecupered() {
		return recupered;
	}

	public void setRecupered(int recupered) {
		this.recupered = recupered;
	}
}
