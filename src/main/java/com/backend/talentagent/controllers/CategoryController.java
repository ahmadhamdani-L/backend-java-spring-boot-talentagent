package com.backend.talentagent.controllers;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.model.Category;
import com.backend.talentagent.services.CategoryService;

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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public ResponseEntity<?> findAllCategory(){
        List<Category> categories = categoryService.findAllCategory();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
       Category cate = categoryService.addCategory(category);
        return ResponseEntity.ok().body(cate);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findCategoryById(@RequestParam("id") Long id){
      Optional<Category> category = categoryService.findCategoryById(id);

      if(!category.isPresent()){
        return ResponseEntity.badRequest().body("gada woii");
      }
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Long id){
        try{
            categoryService.deleteCategoryById(id);
            return ResponseEntity.ok().body("yoi didelete");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("gada coii");
        }
    }

    
}
