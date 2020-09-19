package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaBasketContactRepository extends MongoRepository<FoodaBasketContactDto, Long> {
    Page<FoodaBasketContactDto> findAllByUserId(final Long userId, Pageable page);
}