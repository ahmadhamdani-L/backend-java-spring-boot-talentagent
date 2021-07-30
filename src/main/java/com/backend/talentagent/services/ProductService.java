package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.model.Product;

public interface ProductService {

    List<Product> findAllProduct();

    // insert object product ke db
    Product addProduct(Product product);

    //cari data product sesuai id yg dikirim
    Optional<Product> findProductById(Long id);

    //delete 
    void deleteProductById(Long id);
}
