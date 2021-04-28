package com.catalog.catalog.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    Long categoryId;
    String categoryName;
    String categoryDesc;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "category")
    List<SubCategory> sub_categories = new ArrayList<>();

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "category1")
    List<CatalogInfo> catalogs_category_ifs = new ArrayList<>();


}
