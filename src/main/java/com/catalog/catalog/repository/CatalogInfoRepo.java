package com.catalog.catalog.repository;

import com.catalog.catalog.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogInfoRepo extends JpaRepository<CatalogInfo,Long> {

    List<CatalogInfo> findByBrand(Brand brand);

    List<CatalogInfo> findByCategory1(Category category1);

    List<CatalogInfo> findBySubCategory(SubCategory subcategory);

    List<CatalogInfo> findByColor(String colour);

    List<CatalogInfo> findBySize(Float size);


    @Query(value = "SELECT * FROM CATALOG_INFO WHERE PRICE >=  :minP AND PRICE <= :maxP",nativeQuery = true)
    List<CatalogInfo> findByPrice(Integer minP, Integer maxP);
}
