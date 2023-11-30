package com.example.HistoricalCoins.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "coinTable")
public class Coin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Nonnull
	private Long id;
	
	@Column
	@Nonnull
    private String country;
	
	@Column
	@Nonnull
    private String denomination;
	
	@Column
	@Nonnull
    private int yearOfMinting;
	
	@Column
	@Nonnull
    private int currentValue;
    
    @Column
	@Nonnull
    private int acquiredYear;
    
    @Column
	@Nonnull
    private String imgUrl;

    public Coin() {
        
    } 

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getDenomination() {
        return denomination;
    }

    public int getYearOfMinting() {
        return yearOfMinting;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getAcquiredYear() {
        return acquiredYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public void setYearOfMinting(int yearOfMinting) {
        this.yearOfMinting = yearOfMinting;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void setAcquiredYear(int acquiredYear) {
        this.acquiredYear = acquiredYear;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
	
	
}
