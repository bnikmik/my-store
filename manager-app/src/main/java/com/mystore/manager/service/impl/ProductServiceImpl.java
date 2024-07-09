package com.mystore.manager.service.impl;

import com.mystore.manager.entity.Product;
import com.mystore.manager.repository.ProductRepository;
import com.mystore.manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product((null), title, details));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void updateProduct(Integer productId, String title, String details) {
        this.productRepository.findById(productId)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, (() -> {
                    throw new NoSuchElementException();
                }));
    }

    @Override
    public void deleteProduct(Integer productId) {
        this.productRepository.deleteById(productId);
    }
}
