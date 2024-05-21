package com.test.sber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
/**
 * Общий интерфейс репозитория для сущностей.
 * @param <T> Тип сущности.
 * @param <ID> Тип идентификатора сущности.
 */
@NoRepositoryBean
public interface EntityRepository<T, ID> extends JpaRepository<T, ID> {
}
