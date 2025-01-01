package com.rxhms.hearify.favorite.repository;

import com.rxhms.hearify.favorite.business.Favorite;
import com.rxhms.hearify.favorite.business.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
    boolean existsById(FavoriteId favoriteId);
}

