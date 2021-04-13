package com.catalog.catalog.controller;


import com.catalog.catalog.service.BrandService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;
    /*@GetMapping("/view/item/{brandId}")
    public List<>*/

    @GetMapping("/validCheck/brand/{brandId}")
    public boolean checkValidilty(@PathVariable ("brandId") Integer brandId){
        Boolean isValid = brandService.checkValidity(brandId);
        return isValid;
    }
}
