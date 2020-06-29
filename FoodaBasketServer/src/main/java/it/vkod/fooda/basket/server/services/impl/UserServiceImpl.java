package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.User;
import it.vkod.fooda.basket.server.repositories.UserRepository;
import it.vkod.fooda.basket.server.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void add(User user) {
        repository.save(user);
    }

    @Override
    public void add(List<User> users) {
        repository.saveAll(users);
    }

    @Override
    public void edit(User user, BigInteger id) {
        if (repository.existsById(id))
            repository.save(user);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public Optional<User> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public Page<User> get(Pageable page) {
        return null;
    }

    @Override
    public Page<User> get(BigInteger userId, Pageable pageable) {
        final User list = repository.findById(userId).orElse(null);
        return new PageImpl<>(Collections.singletonList(list), pageable, 1);
    }

    @Override
    public Boolean exists(User user) {
        return repository.exists(Example.of(user));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }

    @Override
    public boolean login(String username, String password) {
        return repository.existsByUsernameAndPassword(username, password);
    }

    @Override
    public void logout(BigInteger userId) {
        repository.findById(userId).ifPresentOrElse(
                user -> user.setActive(false),
                () -> log.error("Logout failed, User already logged out or it does not exists"));
    }
}