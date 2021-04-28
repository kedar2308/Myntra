package com.catalog.catalog.DTO;

import com.catalog.catalog.entity.CatalogInfo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandDTO {
    Integer brandId;
    String brandName;
    String brandDesc;
    List<CatalogInfo> catalogs_ifs = new ArrayList<>();
}
