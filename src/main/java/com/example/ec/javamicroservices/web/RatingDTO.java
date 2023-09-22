package com.example.ec.javamicroservices.web;


public class RatingDTO {

    // @Min(1)
    // @Max(5)
    private Integer score;

    // @Size(max = 255)
    private String comment;

    // @Size(min=2, max=255)
    private String customerName;

    public RatingDTO(Integer score, String comment, String customerName) {
        this.score = score;
        this.comment = comment;
        this.customerName = customerName;
    }

    public RatingDTO() {
        this.score = 5;
        this.comment = "";
        this.customerName = "Anonymus";
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
