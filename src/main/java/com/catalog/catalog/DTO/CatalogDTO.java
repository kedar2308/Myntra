package com.catalog.catalog.DTO;

import com.catalog.catalog.entity.CatalogInfo;
import com.catalog.catalog.entity.Review;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CatalogDTO {
    String catalogDescription;
    Long stock;
    Integer price;
    Boolean COD_Availability;
    List<Review> reviews = new ArrayList<>();
    CatalogInfoDTO catalogInfo;
}
