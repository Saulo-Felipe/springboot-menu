package com.example.menu.controllers;

import com.example.menu.domain.food.Food;
import com.example.menu.repositories.FoodRepository;
import com.example.menu.domain.food.FoodRequestDTO;
import com.example.menu.domain.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAll() {
        List<FoodResponseDTO> response = this.foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Food> create(@RequestBody FoodRequestDTO data) {
        Food food = new Food(data);

        return ResponseEntity.ok(this.foodRepository.save(food));
    }

}
