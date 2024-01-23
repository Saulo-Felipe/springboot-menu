package com.example.menu.controllers;

import com.example.menu.modules.food.FoodRepository;
import com.example.menu.modules.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return foodRepository
                .findAll()
                .stream()
                .map(FoodResponseDTO::new)
                .toList();
    }

}