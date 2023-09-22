package com.example.ec.javamicroservices;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourDifficultyEnum;
import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.domain.TourRatingPK;
import com.example.ec.javamicroservices.domain.TourRegionEnum;

import com.example.ec.javamicroservices.service.TourPackageService;
import com.example.ec.javamicroservices.service.TourRatingService;
import com.example.ec.javamicroservices.service.TourService;

import com.example.ec.javamicroservices.util.JsonTourMapper;
import com.example.ec.javamicroservices.web.RatingDTO;
import com.example.ec.javamicroservices.web.TourRatingController;

@SpringBootApplication
@Configuration("ApplicationProperties")
public class JavamicroservicesApplication implements CommandLineRunner {

	@Autowired
	private TourService tourService;

	@Autowired
	private TourPackageService tourPackageService;

	@Autowired
	private TourRatingService tourRatingService;

	@Autowired
	TourRatingController tourRatingController;

	@Value("${caltourinfo}")
	private String caltourinfo;

	public static void main(String[] args) {

		SpringApplication.run(JavamicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// tourRatingController = new TourRatingController(tourRatingService);
		loadToursAtStart();

	}

	private void loadToursAtStart() throws IOException {

		createDefaultTourPackages();
		createDefaultSampleTours();
		createDefaultSampleRatings();

		System.out.println("Loading from json");
		loadToursFromJsonFile(getJsonFileName());

		System.out.println("Total tour are :" + tourService.total()
				+ " and packages are:" + tourPackageService.total());
	}

	private String getJsonFileName() {
		return this.getClass().getResource("/caltourinfo.json").getPath();
	}

	private void createDefaultTourPackages() {

		tourPackageService.createTourPackage("Tour Package 1", "TP-1");
		tourPackageService.createTourPackage("Tour Package 2", "TP-2");
		tourPackageService.createTourPackage("Tour Package 3", "TP-3");
		tourPackageService.createTourPackage("Tour Package 4", "TP-4");
		System.out.println("Total tour packes are: " + tourPackageService.total());
	}

	private void createDefaultSampleTours() {
		tourService.createTour("Tour 1", "Description 1", 100.0, "1 day", TourRegionEnum.Northern_California,
				TourDifficultyEnum.EASY, "Tour Package 1");

		tourService.createTour("Tour 2", "Description 2", 100.0, "1 day", TourRegionEnum.Southern_California,
				TourDifficultyEnum.MEDIUM, "Tour Package 2");
		tourService.createTour("Tour 3", "Description 3", 100.0, "1 day", TourRegionEnum.Central_Coast,
				TourDifficultyEnum.HARD, "Tour Package 3");
		tourService.createTour("Tour 4", "Description 1", 100.0, "1 day", TourRegionEnum.Varies,
				TourDifficultyEnum.VARIES, "Tour Package 1");
		System.out.println("Total tours are: " + tourService.total());

	}

	private void createDefaultSampleRatings() {

		Tour tour = tourService.createTour("RatingTour", "RatingTour", 100.0, "infinite",
				TourRegionEnum.Central_Coast, TourDifficultyEnum.HARD, "Tour Package 1");

		TourRating rating = new TourRating(new TourRatingPK(tour, "User1"), 3, "first review comment");
		tourRatingService.save(rating);

		RatingDTO obj = new RatingDTO(2, "comment dto", "DTOName");
		tourRatingController.createTourRating(tour.getId(), obj);

		System.out.println("Added comments for tourId:" + tour.getId() + " name:" + tour.getTitle());
		System.out.println("Avg rating is : " + tourRatingController.getAvgRating(tour.getId()));
	}

	public void loadToursFromJsonFile(String filename) throws IOException {

		JsonTourMapper mapper = new JsonTourMapper();

		mapper.read(filename)
				.forEach(tourEntryFromFile -> {
					tourPackageService.createTourPackage(tourEntryFromFile.getPackageType(),
							tourEntryFromFile.getPackageType());
					tourService.createTour(
							tourEntryFromFile.getTitle(),
							tourEntryFromFile.getDescription(),
							tourEntryFromFile.getPrice(),
							tourEntryFromFile.getDuration(),
							tourEntryFromFile.getRegion(),
							tourEntryFromFile.getDifficulty(),
							tourEntryFromFile.getPackageType());
				});
	}

}
