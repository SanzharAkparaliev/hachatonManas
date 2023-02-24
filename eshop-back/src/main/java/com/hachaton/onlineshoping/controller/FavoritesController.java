package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.entity.Favorites;
import com.hachaton.onlineshoping.model.FavoritesDTO;
import com.hachaton.onlineshoping.service.FavoritesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoritesController {
    private final FavoritesService favoritesService;
    @GetMapping("/user/{id}")
    public List<FavoritesDTO> getFavoritesByUser(@PathVariable("id")Long userId){
        return favoritesService.getByUser(userId);
    }

    @DeleteMapping("/{id}")
    public FavoritesDTO deletingFavorites(@PathVariable("id") Long id){
        return favoritesService.delete(id);
    }

    @PostMapping
    public FavoritesDTO createFavorite(@RequestBody FavoritesDTO favoritesDTO){
       return favoritesService.create(favoritesDTO);
    }
}
