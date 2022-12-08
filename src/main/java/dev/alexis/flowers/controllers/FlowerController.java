package dev.alexis.flowers.controllers;

import dev.alexis.flowers.models.Flower;
import dev.alexis.flowers.services.FlowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("api/flowers") @RequiredArgsConstructor @Slf4j
public class FlowerController {

    private final FlowerService flowerService;

    @PostMapping("")
    public ResponseEntity<List<Flower>> saveFlowerList(@RequestBody List<Flower> flowerList) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/flowers").toUriString());
        return ResponseEntity.created(uri).body(flowerService.saveFlowerList(flowerList));
    }

    @GetMapping("")
    public ResponseEntity<List<Flower>> obtainFlowerList() {
        return ResponseEntity.ok().body(flowerService.obtainFlowerList());
    }

    @GetMapping("/upper")
    public ResponseEntity<List<Flower>> obtainUpperToTwelve() {
        return ResponseEntity.ok().body(flowerService.obtainAllTwelveOrUpper());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Flower>> obtainFlowerListByName(@PathVariable String name) {
        return ResponseEntity.ok().body(flowerService.obtainAllByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> deleteFlower(@PathVariable Long id) {
        try {
            flowerService.deleteFlower(id);
            return ResponseEntity.ok().body(Boolean.TRUE);
        } catch (Exception e) {
            log.error("Problem deleting flower: ", e);
            return ResponseEntity.badRequest().body(Boolean.FALSE);
        }
    }


}
