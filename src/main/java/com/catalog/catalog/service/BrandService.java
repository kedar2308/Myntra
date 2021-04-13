package com.catalog.catalog.service;

import com.catalog.catalog.entity.Brand;
import com.catalog.catalog.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BrandService {

    @Autowired
    BrandRepo brandRepo;
    public Boolean checkValidity(Integer brandId) {
        Optional<Brand> optional = brandRepo.findById(brandId);
        if(optional.isEmpty()){
            return false;
        }
        return true;

    }
}
