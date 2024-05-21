package com.test.sber.service;

import java.util.List;
import java.util.Optional;

public interface EntityService<T,ID> {
    List<T> findAll();
    Optional<T> save(T entity);
    Optional<T> findById(ID id);
    Optional<T> update(T entity);
    void removeById(ID id);
}
