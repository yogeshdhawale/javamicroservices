package com.example.ec.javamicroservices.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TourPackage implements Serializable {

    @Id
    @Indexed
    String code;

    @Indexed
    String name;

    public TourPackage(String name, String code) {
        this.name = name;
        this.code = code;
    }

    protected TourPackage() {

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // is equal
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TourPackage that = (TourPackage) o;
        return name.equals(that.name) && code.equals(that.code);
    }

    // hashcode
    @Override
    public int hashCode() {
        return name.hashCode() + code.hashCode();
    }

}