package com.catalog.catalog.service;

import com.catalog.catalog.DTO.CatalogDTO;
import com.catalog.catalog.entity.*;
import com.catalog.catalog.repository.BrandRepo;
import com.catalog.catalog.repository.CatalogInfoRepo;
import com.catalog.catalog.repository.CategoryRepo;
import com.catalog.catalog.repository.SubCategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CatalogInfoService {

    @Autowired
    CatalogInfoRepo catalogInfoRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    BrandRepo brandRepo;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public List<CatalogDTO> filterAccordingToBrand(Integer brandId) {
        Brand brand = brandRepo.findById(brandId).get();
        List<CatalogInfo> catalogInfoList = catalogInfoRepo.findByBrand(brand);
        List<CatalogDTO> catalogDTO_List = new ArrayList<>();
        for (CatalogInfo catalogInfo: catalogInfoList
             ) {
            CatalogDTO catalogDTO = new CatalogDTO();

            Catalog catalog = catalogInfo.getCatalog();
            modelMapper.map(catalog,catalogDTO);
            catalogDTO_List.add(catalogDTO);
        }
        return catalogDTO_List;
    }


    @Transactional
    public List<CatalogDTO> filterAccordingToCategory(Long categoryId) {
        Optional<Category> optional= categoryRepo.findById(categoryId);
        if(optional.isEmpty()){
            return null;
        }
        Category category1 = optional.get();
        List<CatalogInfo> catalogInfoList = catalogInfoRepo.findByCategory1(category1);
        List<CatalogDTO> catalogDTO_List = new ArrayList<>();
        for (CatalogInfo catalogInfo: catalogInfoList
        ) {
            CatalogDTO catalogDTO = new CatalogDTO();

            Catalog catalog = catalogInfo.getCatalog();
            modelMapper.map(catalog,catalogDTO);
            catalogDTO_List.add(catalogDTO);
        }
        return catalogDTO_List;
    }

    public List<CatalogDTO> filterAccordingToSubcategory(Long subcategoryId) {
        Optional<SubCategory> optional= subCategoryRepo.findById(subcategoryId);
        if(optional.isEmpty()){
            return null;
        }
        SubCategory subcategory = optional.get();
        List<CatalogInfo> catalogInfoList = catalogInfoRepo.findBySubCategory(subcategory);
        List<CatalogDTO> catalogDTO_List = new ArrayList<>();
        for (CatalogInfo catalogInfo: catalogInfoList
        ) {
            CatalogDTO catalogDTO = new CatalogDTO();

            Catalog catalog = catalogInfo.getCatalog();
            modelMapper.map(catalog,catalogDTO);
            catalogDTO_List.add(catalogDTO);
        }
        return catalogDTO_List;
    }

    public List<CatalogDTO> filterAccordingToColour(String colour) {
        List<CatalogInfo> catalogInfoList = catalogInfoRepo.findByColor(colour);
        List<CatalogDTO> catalogDTO_List = new ArrayList<>();
        for (CatalogInfo catalogInfo: catalogInfoList
        ) {
            CatalogDTO catalogDTO = new CatalogDTO();

            Catalog catalog = catalogInfo.getCatalog();
            modelMapper.map(catalog,catalogDTO);
            catalogDTO_List.add(catalogDTO);
        }
        return catalogDTO_List;
    }

    public List<CatalogDTO> filterAccordingToSize(Float size) {
        List<CatalogInfo> catalogInfoList = catalogInfoRepo.findBySize(size);
        List<CatalogDTO> catalogDTO_List = new ArrayList<>();
        for (CatalogInfo catalogInfo: catalogInfoList
        ) {
            CatalogDTO catalogDTO = new CatalogDTO();

            Catalog catalog = catalogInfo.getCatalog();
            modelMapper.map(catalog,catalogDTO);
            catalogDTO_List.add(catalogDTO);
        }
        return catalogDTO_List;
    }

    public List<CatalogDTO> filterByPrice(Integer minPrice, Integer maxPrice) {
        List<CatalogInfo> catalogInfoList = catalogInfoRepo.findByPrice(minPrice,maxPrice);
        List<CatalogDTO> catalogDTO_List = new ArrayList<>();
        for (CatalogInfo catalogInfo: catalogInfoList
        ) {
            CatalogDTO catalogDTO = new CatalogDTO();

            Catalog catalog = catalogInfo.getCatalog();
            modelMapper.map(catalog,catalogDTO);
            catalogDTO_List.add(catalogDTO);
        }
        return catalogDTO_List;
    }
}
