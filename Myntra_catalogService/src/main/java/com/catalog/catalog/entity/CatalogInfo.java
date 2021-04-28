package com.catalog.catalog.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatalogInfo {
    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    Long catalogInfoId;
    String color;
    Float size;
    String gender;
    Integer price;
    Float discount;

    @ManyToOne
    @JoinColumn(name="categoryId")
    Category category1;

    @ManyToOne
    @JoinColumn(name="sub_categoryId")
    SubCategory subCategory;

    @ManyToOne
    @JsonBackReference(value="two")
    @JoinColumn(name="brandId")
    Brand brand;

    @OneToOne(mappedBy = "catalogInfo",cascade=CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonBackReference(value="three")
    Catalog catalog;


    @Override
    public String toString() {
        return "CatalogInfo{" +
                "catalogInfoId=" + catalogInfoId +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
