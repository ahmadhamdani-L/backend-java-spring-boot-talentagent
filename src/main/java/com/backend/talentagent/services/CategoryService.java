package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.model.Category;

public interface CategoryService {

    List<Category> findAllCategory();

    // insert object category ke db
    Category addCategory(Category category);

    //cari data category sesuai id yg dikirim
    Optional<Category> findCategoryById(Long id);

    //delete 
    void deleteCategoryById(Long id);
}
