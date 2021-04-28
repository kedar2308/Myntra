package com.catalog.catalog.repository;

import com.catalog.catalog.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepo extends JpaRepository<Catalog,Long> {

    @Query(value = "SELECT * FROM CATALOG LIMIT 30",nativeQuery = true)
    List<Catalog> userSpecificItems();
}
