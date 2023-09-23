package com.example.ec.javamicroservices.domain;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Tour implements Serializable {
    @Id
    String Id;

    public String getId() {
        return Id;
    }

    @Indexed
    String title;

    String description;

    Double price;

    String duration;

    @Indexed
    private String tourPackageCode;

    public String getTourPackageCode() {
        return tourPackageCode;
    }

    public void setTourPackageCode(String tourPackageCode) {
        this.tourPackageCode = tourPackageCode;
    }

    @Indexed
    private String tourPackageName;

    public String getTourPackageName() {
        return tourPackageName;
    }

    public void setTourPackageName(String tourPackageName) {
        this.tourPackageName = tourPackageName;
    }

    // for key value info like description, keywords, etc
    private Map<String, String> details;

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public Tour(String title, TourPackage tourPackage, Map<String, String> details) {
        
        this.title = title;
        this.tourPackageCode = tourPackage.getCode();
        this.tourPackageName = tourPackage.getName();

        this.details = details;
    }

    protected Tour() {
    }

    @Override
    public String toString() {
        return "Tour [Id=" + Id + ", tourPackageCode=" + tourPackageCode + ", tourPackageName=" + tourPackageName
                + ", details=" + details + "]";
    }

};
