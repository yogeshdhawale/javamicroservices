package com.example.ec.javamicroservices.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TourRatingPK implements Serializable {

    @ManyToOne
    private Tour tour;

    @Column(updatable = false, nullable = false)
    private String customerName;

    public TourRatingPK(Tour tour, String customerName) {
        this.tour = tour;
        this.customerName = customerName;
    }

    protected TourRatingPK() {
        
    }

}
