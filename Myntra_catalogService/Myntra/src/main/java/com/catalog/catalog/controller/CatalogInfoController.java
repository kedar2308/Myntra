package com.catalog.catalog.controller;

import com.catalog.catalog.DTO.CatalogDTO;
import com.catalog.catalog.entity.Catalog;
import com.catalog.catalog.service.BrandService;
import com.catalog.catalog.service.CatalogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CatalogInfoController {

    @Autowired
    CatalogInfoService catalogInfoService;

    @Autowired
    BrandService brandService;

    @GetMapping("/view/item/brand/{brandId}")
    @Transactional
    public List<CatalogDTO> filterAccordingToBrand(@PathVariable ("brandId") Integer brandId){
        if(!brandService.checkValidity(brandId)){
            return null;
        }
        List<CatalogDTO> catalogDTO_List = catalogInfoService.filterAccordingToBrand(brandId);
        return catalogDTO_List;
    }

    @GetMapping("/view/item/category/{categoryId}")
    @Transactional
    public List<CatalogDTO> filterAccordingToCategory(@PathVariable ("categoryId") Long categoryId){

        List<CatalogDTO> catalogDTO_List = catalogInfoService.filterAccordingToCategory(categoryId);
        return catalogDTO_List;
    }

    @GetMapping("/view/item/sub_category/{sub_categoryId}")
    @Transactional
    public List<CatalogDTO> filterAccordingToSubcategory(@PathVariable ("sub_categoryId") Long subcategoryId){

        List<CatalogDTO> catalogDTO_List = catalogInfoService.filterAccordingToSubcategory(subcategoryId);
        return catalogDTO_List;
    }



    @GetMapping("/view/item/colour/{colour}")
    @Transactional
    public List<CatalogDTO> filterAccordingToColour(@PathVariable ("colour") String colour){

        List<CatalogDTO> catalogDTO_List = catalogInfoService.filterAccordingToColour(colour);
        return catalogDTO_List;
    }

    @GetMapping("/view/item/size/{size}")
    @Transactional
    public List<CatalogDTO> filterAccordingToSize(@PathVariable ("size") Float size){

        List<CatalogDTO> catalogDTO_List = catalogInfoService.filterAccordingToSize(size);
        return catalogDTO_List;
    }

    @GetMapping("/view/item/price/{min_price}/to/{max_price}")
    @Transactional
    public List<CatalogDTO> filterByPrice(@PathVariable ("min_price") Integer minPrice,@PathVariable ("max_price") Integer maxPrice){

        List<CatalogDTO> catalogDTO_List = catalogInfoService.filterByPrice(minPrice,maxPrice);
        return catalogDTO_List;
    }




}
