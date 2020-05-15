package it.vkod.woo.basket.service.repositories;

import it.vkod.woo.basket.service.payloads.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, UUID> {
    List<Payment> findAllByUserId(final long userId);
    List<Payment> findAllByUserIdAndStoreId(final long userId, final long storeId);
}