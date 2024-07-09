package com.mystore.manager.service;

import com.mystore.manager.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для товаров
 */
public interface ProductService {

    /**
     * Получить все товары
     *
     * @return список товаров
     */
    List<Product> findAllProducts();

    /**
     * Сохранить новый товар
     *
     * @param title название
     * @param details описание
     * @return сохраненный товар
     */
    Product createProduct(String title, String details);

    /**
     * Найти товар по ID
     *
     * @param productId id товара
     * @return опшенал товара
     */
    Optional<Product> findProduct(Integer productId);

    /**
     * Обновить товар по id
     *
     * @param productId id товара
     */
    void updateProduct(Integer productId, String title, String details);

    /**
     * Удалить товар по id
     *
     * @param productId id товара
     */
    void deleteProduct(Integer productId);
}
