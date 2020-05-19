package it.vkod.woo.basket.service.repositories;

import it.vkod.woo.basket.service.payloads.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BasketRepo extends JpaRepository<Basket, UUID> {
    List<Basket> findAllByUserId(final String userId);
    boolean existsByUserIdAndStoreIdAndProductId(final String userId, final long storeId, final long productId);
    Basket findByUserIdAndStoreIdAndProductId(final String userId, final long storeId, final long productId);
}
