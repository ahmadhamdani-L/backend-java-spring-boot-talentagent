package com.backend.talentagent.controllers;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.model.Product;
import com.backend.talentagent.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping
    public ResponseEntity<?> findAllProduct(){
        List<Product> categories = productService.findAllProduct();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
       Product prod= productService.addProduct(product);
        return ResponseEntity.ok().body(prod);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findProductById(@RequestParam("id") Long id){
      Optional<Product> product = productService.findProductById(id);

      if(!product.isPresent()){
        return ResponseEntity.badRequest().body("gada woii");
      }
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id){
        try{
            productService.deleteProductById(id);
            return ResponseEntity.ok().body("yoi didelete");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("gada coii");
        }
    }

    
}
