package com.catalog.catalog.controller;

import com.catalog.catalog.DTO.SubCategoryDTO;
import com.catalog.catalog.entity.SubCategory;
import com.catalog.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @GetMapping("/view/item/sub_category/category/{categoryId}")
    public List<SubCategoryDTO> getSubcategory(@PathVariable ("categoryId") Long categoryId){
        List<SubCategoryDTO> subcategories = categoryService.getSubcategory(categoryId);
        return subcategories;

    }
}
