package dev.alexis.flowers;

import dev.alexis.flowers.repositories.FlowerRepository;
import dev.alexis.flowers.services.FlowerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlowersApplicationTests {

	@Mock
	private FlowerRepository flowerRepository;
	private FlowerService flowerService;
	private AutoCloseable autoCloseable;


	@BeforeEach
	void setUp(){
		autoCloseable = MockitoAnnotations.openMocks(this);
		flowerService = new FlowerService(flowerRepository);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void shouldSaveFlowersList() {
		// Given

		// When

		// Then
	}

	@Test
	void shouldReplaceFlowersList() {

	}

	@Test
	void couldNotSaveFlowersList() {

	}

	@Test
	void shouldGiveFlowersListWithSuffixInNameAndWithoutId() {

	}

	@Test
	void shouldGiveOnlyTheFlowersWithPriceHigherThan20AndAllAttributes() {

	}

	@Test
	void shouldDeleteAFlowerById() {

	}

	@Test
	void shouldFindFlowersThatMatchWithAName() {

	}

}
