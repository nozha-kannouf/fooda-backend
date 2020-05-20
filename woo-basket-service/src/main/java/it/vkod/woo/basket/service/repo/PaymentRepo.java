package it.vkod.woo.basket.service.repo;

import it.vkod.woo.basket.service.data.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, UUID> {
    List<Payment> findAllByUserId(final String userId);
    List<Payment> findAllByUserIdAndStoreId(final String userId, final long storeId);
}