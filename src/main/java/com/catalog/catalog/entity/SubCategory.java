package com.catalog.catalog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class SubCategory {

    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    Long subCategoryId;
    String subCategoryName;
    String subCategoryDesc;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonBackReference(value="five")
    Category category;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "subCategory")
    List<CatalogInfo> catalogs_ifs = new ArrayList<>();


}
