package dev.alexis.flowers.services;

import dev.alexis.flowers.models.Flower;
import dev.alexis.flowers.repositories.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class FlowerService {

    private final FlowerRepository flowerRepository;
    private final Long MINUS_PRICE = 20L;
    private final String SUFFIX = "-kometsales";

    public List<Flower> saveFlowerList(List<Flower> flowersList) {
        flowersList.forEach(flower -> flower.setName(flower.getName()+SUFFIX));
        return flowerRepository.saveFlowerList(flowersList);
    }

    public List<Flower> obtainFlowerList() {
        List<Flower> unsorted = flowerRepository.obtainFlowerList();
        return withOutId(sort(unsorted));
    }

    public List<Flower> obtainAllTwelveOrUpper() {
        List<Flower> unsorted = flowerRepository.obtainFlowerList();
        return sort(unsorted.stream().filter(flower -> flower.getPrice() > MINUS_PRICE).collect(Collectors.toList()));
    }

    public List<Flower> obtainAllByName(String name) {
        List<Flower> unsorted = flowerRepository.obtainFlowerList();
        return unsorted.stream().filter(flower -> flower.getName().contains(name)).collect(Collectors.toList());
    }

    public Boolean deleteFlower(Long id) {
        return flowerRepository.deleteFlower(id);
    }

    private List<Flower> sort(List<Flower> list) {
        Collections.sort(list, Comparator.comparing(Flower::getName));
        return list;
    }

    private List<Flower> withOutId(List<Flower> list) {
        list.forEach(flower -> flower.setId(null));
        return list;
    }
}
