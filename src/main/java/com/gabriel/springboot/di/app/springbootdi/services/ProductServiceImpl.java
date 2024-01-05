package com.gabriel.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

import com.gabriel.springboot.di.app.springbootdi.models.Product;
import com.gabriel.springboot.di.app.springbootdi.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(
                p -> {
                    Double priceImp = p.getPrice() * 1.25d;
                    // Product newProduct = new Product(p.getId(), p.getName(),
                    // priceImp.longValue());
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(priceImp.longValue());
                    return newProduct;
                }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

}
