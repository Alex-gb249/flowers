package dev.alexis.flowers.services;

import dev.alexis.flowers.models.Flower;
import dev.alexis.flowers.repositories.FlowerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FlowerServiceTest {

    @Mock
    private FlowerRepository flowerRepository;
    @InjectMocks
    private FlowerService flowerService;

    private final List<Flower> listBeforeSave = new ArrayList<>();
    private final List<Flower> listAfterSave = new ArrayList<>();
    private final List<Flower> orderedListAfterSave = new ArrayList<>();
    private final List<Flower> valueUpToTwelve = new ArrayList<>();
    private final List<Flower> findedByName = new ArrayList<>();

    @BeforeEach
    void setUp(){
        flowerService = new FlowerService(flowerRepository);
        listBeforeSave.add(new Flower(1L,"Orquidea",80L));
        listBeforeSave.add(new Flower(2L,"Margarita",10L));
        listBeforeSave.add(new Flower(3L,"Lirio",20L));
        listBeforeSave.add(new Flower(4L,"Rosa",21L));
        listBeforeSave.add(new Flower(5L,"Tulipan",70L));

        listAfterSave.add(new Flower(1L,"Orquidea-kometsales",80L));
        listAfterSave.add(new Flower(2L,"Margarita-kometsales",10L));
        listAfterSave.add(new Flower(3L,"Lirio-kometsales",20L));
        listAfterSave.add(new Flower(4L,"Rosa-kometsales",21L));
        listAfterSave.add(new Flower(5L,"Tulipan-kometsales",70L));

        orderedListAfterSave.add(new Flower(null,"Lirio-kometsales",20L));
        orderedListAfterSave.add(new Flower(null,"Margarita-kometsales",10L));
        orderedListAfterSave.add(new Flower(null,"Orquidea-kometsales", 80L));
        orderedListAfterSave.add(new Flower(null,"Rosa-kometsales",21L));
        orderedListAfterSave.add(new Flower(null,"Tulipan-kometsales",70L));

        valueUpToTwelve.add(new Flower(1L,"Orquidea-kometsales",80L));
        valueUpToTwelve.add(new Flower(4L,"Rosa-kometsales",21L));
        valueUpToTwelve.add(new Flower(5L,"Tulipan-kometsales",70L));

        findedByName.add(new Flower(2L,"Margarita-kometsales",10L));
        findedByName.add(new Flower(3L,"Lirio-kometsales",20L));
    }

    @Test
    void shouldSaveFlowersList() {
        when(flowerRepository.saveFlowerList(listAfterSave)).thenReturn(listAfterSave);
        List<Flower> actualList = flowerService.saveFlowerList(listBeforeSave);
        Assertions.assertEquals(listAfterSave, actualList);
    }

    @Test
    void shouldGiveFlowersListWithoutId() {
        when(flowerRepository.obtainFlowerList()).thenReturn(listAfterSave);
        List<Flower> actualList = flowerService.obtainFlowerList();
        Assertions.assertEquals(orderedListAfterSave, actualList);
    }

    @Test
    void shouldGiveOnlyTheFlowersWithPriceHigherThan20AndAllAttributes() {
        when(flowerRepository.obtainFlowerList()).thenReturn(listAfterSave);
        List<Flower> actualList = flowerService.obtainAllTwelveOrUpper();
        Assertions.assertEquals(valueUpToTwelve, actualList);
    }

    @Test
    void shouldDeleteAFlowerById() {
        when(flowerRepository.deleteFlower(1L)).thenReturn(Boolean.TRUE);
        Assertions.assertTrue(flowerService.deleteFlower(1L));
    }

    @Test
    void shouldFindFlowersThatMatchWithAName() {
        when(flowerRepository.obtainFlowerList()).thenReturn(listAfterSave);
        List<Flower> actualList = flowerService.obtainAllByName("ri");
        Assertions.assertEquals(findedByName, actualList);
    }

}