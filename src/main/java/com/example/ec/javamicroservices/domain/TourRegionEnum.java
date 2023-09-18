package com.example.ec.javamicroservices.domain;

public enum TourRegionEnum {
    Central_Coast("Central Coast"),
    Southern_California("Southern California"),
    Northern_California("Northern California"),
    Varies("Varies");

    private String label;

    private TourRegionEnum(String label) {
        this.label = label;
    }

    public static TourRegionEnum findByLabel(String byLabel) {
        for (TourRegionEnum r : TourRegionEnum.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

    public String getLabel() {
        return label;
    }
}