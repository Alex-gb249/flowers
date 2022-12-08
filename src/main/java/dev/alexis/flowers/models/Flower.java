package dev.alexis.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Flower {

    private Long id;
    private String name;
    private Long price;
}
