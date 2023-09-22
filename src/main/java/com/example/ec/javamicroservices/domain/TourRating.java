package com.example.ec.javamicroservices.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class TourRating implements Serializable {
    @EmbeddedId
    private TourRatingPK pk;

    public TourRatingPK getPk() {
        return pk;
    }

    @Column
    private Integer score = 3;

    public Integer getScore() {
        return score;
    }

    @Column
    private String reviewComment;

    public String getReviewComment() {
        return reviewComment;
    }

    public TourRating(TourRatingPK pk, Integer score, String reviewComment) {
        this.pk = pk;
        this.score = score;
        this.reviewComment = reviewComment;
    }

    protected TourRating() {

    }

    @Override
    public String toString() {
        return "TourRating [pk=" + pk + ", score=" + score + ", reviewComment=" + reviewComment + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        result = prime * result + ((reviewComment == null) ? 0 : reviewComment.hashCode());
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
        TourRating other = (TourRating) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        if (reviewComment == null) {
            if (other.reviewComment != null)
                return false;
        } else if (!reviewComment.equals(other.reviewComment))
            return false;
        return true;
    }

}
