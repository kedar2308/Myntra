package com.catalog.catalog.DTO;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    Long categoryId;
    String categoryName;
    String categoryDesc;

    List<SubCategoryDTO> sub_categories = new ArrayList<>();

    List<CatalogInfoDTO> catalogs_category_ifs = new ArrayList<>();
}

