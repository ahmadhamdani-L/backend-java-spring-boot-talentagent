package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.model.Product;
import com.backend.talentagent.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> findAllProduct() {
        
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductById(Long id) {
       productRepository.deleteById(id);
        
    }
    
}
