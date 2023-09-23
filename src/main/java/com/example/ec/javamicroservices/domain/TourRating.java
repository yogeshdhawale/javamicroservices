package com.example.ec.javamicroservices.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TourRating implements Serializable {
    @Id
    private String id;

    private String tourId;

    // @NotNull
    private String customerName;

    private Integer score = 3;

    // @NotNull
    private String reviewComment;

    public String getCustomerName() {
        return customerName;
    }

    public String getTourId() {
        return tourId;
    }

    public Integer getScore() {
        return score;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public TourRating(String tourId, String customerName, Integer score, String reviewComment) {
        this.tourId = tourId;
        this.customerName = customerName;
        this.score = score;
        this.reviewComment = reviewComment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tourId == null) ? 0 : tourId.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tourId == null) {
            if (other.tourId != null)
                return false;
        } else if (!tourId.equals(other.tourId))
            return false;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
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

    @Override
    public String toString() {
        return "TourRating [id=" + id + ", tourId=" + tourId + ", customerName=" + customerName + ", score=" + score
                + ", reviewComment=" + reviewComment + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

}
