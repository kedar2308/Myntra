package com.catalog.catalog.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubCategoryDTO {

    Long subCategoryId;
    String subCategoryName;
    String subCategoryDesc;


    CategoryDTO category;

    List<CatalogInfoDTO> catalogs_ifs = new ArrayList<>();
}
