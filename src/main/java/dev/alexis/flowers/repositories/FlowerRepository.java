package dev.alexis.flowers.repositories;

import dev.alexis.flowers.models.Flower;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class FlowerRepository {

    private static List<Flower> flowersList = new ArrayList<>();

    public List<Flower> saveFlowerList(List<Flower> flowersList) {
        FlowerRepository.flowersList = flowersList;
        return null;
    }

    public List<Flower> obtainFlowerList() {
        return flowersList;
    }

    public Boolean deleteFlower(Long id) {
        try {
            flowersList.removeIf(flower -> Objects.equals(flower.getId(), id));
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
