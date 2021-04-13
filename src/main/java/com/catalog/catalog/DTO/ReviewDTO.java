package com.catalog.catalog.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    Integer reviewId;
    String reviewContent;
    Long userId;

    CatalogDTO catalog;
}
