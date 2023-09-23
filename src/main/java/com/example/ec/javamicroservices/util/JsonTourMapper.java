package com.example.ec.javamicroservices.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTourMapper {

	private String title, packageName;
	Map<String, String> details;

	public static List<JsonTourMapper> read(String fileToImport) throws IOException {
		List<Map<String, String>> records = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
				.readValue(
						new FileInputStream(fileToImport),
						new TypeReference<List<Map<String, String>>>() {
						});
		return records.stream().map(JsonTourMapper::new)
				.collect(Collectors.toList());
	}

	public JsonTourMapper(Map<String, String> record) {
		this.title = record.get("title");
		this.packageName = record.get("packageType");
		this.details = record;
		this.details.remove("packageType");
		this.details.remove("title");
	}

	public String getPackageName() {
		return packageName;
	}

	public String getTitle() {
		return title;
	}

	public Map<String, String> getDetails() {
		return details;
	}
}
