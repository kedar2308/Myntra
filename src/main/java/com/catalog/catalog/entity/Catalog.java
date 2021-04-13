package com.catalog.catalog.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table( uniqueConstraints = { @UniqueConstraint( columnNames = {"catalogInfoID"})})
public class Catalog {
    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    Long catalogId;
    String catalogDescription;
    Long stock;
    Integer price;
    Boolean COD_Availability;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "catalog")
    List<Review> reviews = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="catalogInfoID")
    @JsonBackReference(value="one")
    CatalogInfo catalogInfo;

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogDescription='" + catalogDescription + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", COD_Availability=" + COD_Availability +
                ", reviews=" + reviews +
                ", catalogInfo=" + catalogInfo +
                '}';
    }
}
