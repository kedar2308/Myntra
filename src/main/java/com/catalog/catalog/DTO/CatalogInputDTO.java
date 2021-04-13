package com.catalog.catalog.DTO;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CatalogInputDTO {
    Long catalogId;
    String catalogDescription;
    Long stock;
    Integer price;
    Boolean cod_Availability;
    CatalogInfoInputDTO catalogInfoInputDTO;
}
