package com.catalog.catalog.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CatalogInfoDTO {

    Long catalogInfoId;
    String color;
    Float size;
    String gender;
    Integer price;
    Float discount;


    /*CategoryDTO category1;


    SubCategoryDTO subCategory;


    BrandDTO brand;


    CatalogDTO catalog;*/
}

