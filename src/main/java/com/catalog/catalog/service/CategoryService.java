package com.catalog.catalog.service;

//import com.catalog.catalog.DTO.Category;
import com.catalog.catalog.DTO.SubCategoryDTO;
import com.catalog.catalog.entity.Category;
import com.catalog.catalog.entity.SubCategory;
import com.catalog.catalog.repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;
    public List<SubCategoryDTO> getSubcategory(Long categoryId) {

        Optional<Category> optional = categoryRepo.findById(categoryId);
        List<SubCategory> subcategories = optional.get().getSub_categories();
        List<SubCategoryDTO> subcategoryDtoList = new ArrayList<>();
        for (SubCategory subcategory: subcategories
             ) {
            SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
            modelMapper.map(subcategory,subCategoryDTO);
            subcategoryDtoList.add(subCategoryDTO);
        }
        return subcategoryDtoList;
    }
}
