package com.example.ec.javamicroservices.domain;

public enum TourDifficultyEnum {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    VARIES("Varies");

    private String label;

    private TourDifficultyEnum(String label) {
        this.label = label;
    }

    public static TourDifficultyEnum findByLabel(String byLabel) {
        for (TourDifficultyEnum r : TourDifficultyEnum.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

    public String getLabel() {
        return label;
    }
}
