package com.example.ec.javamicroservices.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.example.ec.javamicroservices.domain.TourDifficultyEnum;
import com.example.ec.javamicroservices.domain.TourRegionEnum;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTourMapper {

	private String packageType, title, blurb, description, bullets, difficulty, length, price, region, keywords;

	public List<JsonTourMapper> read(String fileName) throws IOException {

		return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
				.readValue(new FileInputStream(fileName), new TypeReference<List<JsonTourMapper>>() {
				});
	}

	public JsonTourMapper() {
	}

	public String getPackageType() {
		return packageType;
	}

	public String getTitle() {
		return title;
	}

	public String getBlurb() {
		return blurb;
	}

	public String getDescription() {
		return description;
	}

	public String getBullets() {
		return bullets;
	}

	public TourDifficultyEnum getDifficulty() {
		return TourDifficultyEnum.findByLabel(difficulty);
	}

	public String getDuration() {
		return length;
	}

	public Double getPrice() {
		return Double.valueOf(price);
	}

	public TourRegionEnum getRegion() {
		return TourRegionEnum.findByLabel(region);
	}

	public String getKeywords() {
		return keywords;
	}
}
