package dev.alexis.flowers.controllers;

import dev.alexis.flowers.models.Flower;
import dev.alexis.flowers.services.FlowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("api/flowers") @AllArgsConstructor
public class FlowerController {

    private final FlowerService flowerService;

    @PostMapping("")
    public ResponseEntity<List<Flower>> saveFlowerList(@RequestBody List<Flower> flowerList) {
        return null;
    }

    @GetMapping("")
    public ResponseEntity<List<Flower>> obtainFlowerList() {
        return null;
    }

    @GetMapping("/upper")
    public ResponseEntity<List<Flower>> obtainUpperToTwelve() {
        return null;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Flower>> obtainFlowerListByName(@PathVariable String name) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> deleteFlower(@PathVariable Long id) {
        return null;
    }


}
