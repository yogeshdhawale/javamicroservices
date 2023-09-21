package com.example.ec.javamicroservices.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class TourRating implements Serializable {
    @EmbeddedId
    private TourRatingPK pk;

    @Column
    private Integer score = 3;

    @Column
    private String reviewComment;

    public TourRating(TourRatingPK pk, Integer score, String reviewComment) {
        this.pk = pk;
        this.score = score;
        this.reviewComment = reviewComment;
    }

    protected TourRating() {

    }
}
