package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.Favorites;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.FavoritesDTO;

import java.util.List;

public interface FavoritesService {

    List<FavoritesDTO> getByUser(Long userId);
    FavoritesDTO delete(Long id);
    FavoritesDTO create(FavoritesDTO favorites);
}
