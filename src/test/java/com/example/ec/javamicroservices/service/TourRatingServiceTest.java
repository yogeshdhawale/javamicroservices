package com.example.ec.javamicroservices.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.junit.runner.RunWith;

import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.repo.TourRatingsRepo;
import com.example.ec.javamicroservices.repo.TourRepo;

@RunWith(MockitoJUnitRunner.class)
// @ExtendWith(MockitoExtension.class)
// @RunWith(SpringJUnit4ClassRunner.class)
// @RunWith(SpringRunner.class)
public class TourRatingServiceTest {

    private static final String TOUR_ID = "1";
    // private static final String CUSTOMER_NAME = "testUser";
    // private static final int TOUR_RATING_ID = 1;

    @Mock
    private Tour tourMock;
    @Mock
    private TourRepo tourRepoMock;

    @Mock
    private TourRating tourRatingMock;
    @Mock
    private TourRatingsRepo tourRatingsRepoMock;

    @InjectMocks
    // @Autowired
    private TourRatingService service;

    @Rule
    MockitoRule rule = MockitoJUnit.rule();

    @Test
    void testGetTourRatings() throws Exception {

        when(tourRatingsRepoMock.findByTourId(TOUR_ID))
                .thenReturn(List.of(tourRatingMock));

        assertEquals(service.getTourRatings(TOUR_ID).get(0), tourRatingMock);
    }

}
