package com.example.menu.domain.food;

public record FoodResponseDTO(Long id, String image, String title, Integer price) {
    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getImage(), food.getTitle(), food.getPrice());
    }
}
