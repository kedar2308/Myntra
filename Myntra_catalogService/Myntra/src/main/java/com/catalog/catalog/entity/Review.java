package com.catalog.catalog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    Integer reviewId;
    String reviewContent;
    Long userId;
    @ManyToOne
    @JsonBackReference(value="four")
    @JoinColumn(name="catalogId")
    Catalog catalog;
}
