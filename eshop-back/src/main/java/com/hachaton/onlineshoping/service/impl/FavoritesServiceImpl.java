package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.BaseEntity;
import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Favorites;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.FavoritesDTO;
import com.hachaton.onlineshoping.model.UserDTO;
import com.hachaton.onlineshoping.repository.FavoritesRepository;
import com.hachaton.onlineshoping.repository.UserRepository;
import com.hachaton.onlineshoping.service.FavoritesService;
import com.hachaton.onlineshoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;
    private final UserRepository userRepository;
    @Override
    public List<FavoritesDTO> getByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return    favoritesRepository.findByUser(user).stream().map(Favorites::toModel).collect(Collectors.toList());
    }

    @Override
    public FavoritesDTO delete(Long id) {
        return favoritesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Favorites by id: " + id + " cannot be found !")).toModel();}

    @Override
    public FavoritesDTO create(FavoritesDTO favorites) {
         Favorites favoritesInDb = favorites.getId() == null ? new Favorites() : favoritesRepository.getById(favorites.getId());
         favoritesInDb.setProduct(favorites.getProduct());
         favoritesInDb.setUser(favorites.getUser());
        return favoritesRepository.save(favoritesInDb).toModel();
    }
}
