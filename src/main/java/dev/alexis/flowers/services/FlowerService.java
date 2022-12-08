package dev.alexis.flowers.services;

import dev.alexis.flowers.models.Flower;
import dev.alexis.flowers.repositories.FlowerRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FlowerService {

    private final FlowerRepository flowerRepository;

    public List<Flower> saveFlowerList(List<Flower> flowersList) {
        return null;
    }

    public List<Flower> obtainFlowerList() {
        return null;
    }

    public List<Flower> obtainAllTwelveOrUpper() {
        return null;
    }

    public List<Flower> obtainAllByName(String name) {
        return null;
    }

    public Boolean deleteFlower(Long id) {
        return null;
    }
}
