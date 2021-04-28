package com.catalog.catalog.DTO;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CatalogInfoInputDTO {
    Long catalogInfoId;
    String color;
    Float size;
    String gender;
    Integer price;
    Float discount;
    Integer brandId;
    Long categoryId;
    Long subCategoryId;
}
