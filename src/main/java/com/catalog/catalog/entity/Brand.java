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
public class Brand {
    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    Integer brandId;
    String brandName;
    String brandDesc;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "brand")
    List<CatalogInfo> catalogs_ifs = new ArrayList<>();

}
