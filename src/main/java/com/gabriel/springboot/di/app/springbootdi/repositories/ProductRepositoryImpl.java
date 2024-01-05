package com.gabriel.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.gabriel.springboot.di.app.springbootdi.models.Product;

@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Computer", 1000L),
                new Product(2L, "Mouse", 100L),
                new Product(3L, "Keyboard", 150L),
                new Product(4L, "Monitor", 500L)
        );
    }
    
    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


}
