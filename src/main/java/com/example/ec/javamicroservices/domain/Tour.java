package com.example.ec.javamicroservices.domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tour implements Serializable {
    @Id
    @GeneratedValue
    Integer Id;

    public Integer getId() {
        return Id;
    }

    @Column
    String title;

    @Column(length=5000)
    String description;

    @Column
    Double price;

    @Column
    String duration;

    @Column
    List<String> keywords;

    @Column
    @Enumerated
    TourRegionEnum region;

    @Column
    @Enumerated
    TourDifficultyEnum difficulty;

    @ManyToOne
    @JoinColumn(name = "tour_package_code")
    TourPackage tourPackage;

    /**
     * @param title
     * @param description
     * @param price
     * @param duration
     * @param region
     * @param difficulty
     */
    protected Tour(String title, String description, Double price, String duration, TourRegionEnum region,
            TourDifficultyEnum difficulty) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.region = region;
        this.difficulty = difficulty;
        this.tourPackage = null;
    }

    /**
     * @param title2
     * @param description2
     * @param price2
     * @param duration2
     * @param region2
     * @param difficulty2
     * @param tourPackage2
     * 
     */
    public Tour(String title2, String description2, Double price2, String duration2, TourRegionEnum region2,
            TourDifficultyEnum difficulty2, TourPackage tourPackage2) {
        this(title2, description2, price2, duration2, region2, difficulty2);
        this.tourPackage = tourPackage2;
    }

    protected Tour() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDurationInMinutes() {
        return duration;
    }

    public void duration(String duration) {
        this.duration = duration;
    }

    public TourRegionEnum getRegion() {
        return region;
    }

    public TourDifficultyEnum getDifficulty() {
        return difficulty;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

};
