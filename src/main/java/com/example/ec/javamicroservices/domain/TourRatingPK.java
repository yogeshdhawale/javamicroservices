package com.example.ec.javamicroservices.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TourRatingPK implements Serializable {

    @ManyToOne
    private Tour tour;

    public Tour getTour() {
        return tour;
    }

    @Column(updatable = false, nullable = false)
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public TourRatingPK(Tour tour, String customerName) {
        this.tour = tour;
        this.customerName = customerName;
    }

    protected TourRatingPK() {

    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tour == null) ? 0 : tour.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TourRatingPK other = (TourRatingPK) obj;
        if (tour == null) {
            if (other.tour != null)
                return false;
        } else if (!tour.equals(other.tour))
            return false;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TourRatingPK [tour=" + tour + ", customerName=" + customerName + "]";
    }
}
