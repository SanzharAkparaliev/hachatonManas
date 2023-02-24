package com.hachaton.onlineshoping.repository;

import com.hachaton.onlineshoping.entity.Favorites;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Long> {
    List<Favorites> findByUser(User user);
}
