package com.mystore.manager.repository;

import com.mystore.manager.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для товаров
 */
public interface ProductRepository {

    /**
     * Получить все товары
     *
     * @return список товаров
     */
    List<Product> findAll();

    /**
     * Сохранить новый товар
     *
     * @param product товар
     * @return сохраненный товар
     */
    Product save(Product product);

    /**
     * Найти товар по ID
     *
     * @param productId id товара
     * @return опшенал товара
     */
    Optional<Product> findById(Integer productId);

    /**
     * Удалить товар по id
     *
     * @param productId id товара
     */
    void deleteById(Integer productId);
}
