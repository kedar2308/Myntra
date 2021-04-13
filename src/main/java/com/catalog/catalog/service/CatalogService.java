package com.catalog.catalog.service;

import com.catalog.catalog.DTO.*;
import com.catalog.catalog.entity.*;
import com.catalog.catalog.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    @Autowired
    CatalogRepo catalogRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    CatalogInfoRepo catalogInfoRepo;

    @Autowired
    BrandRepo brandRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;


    public CatalogDTO showItem(Long itemId) {
        Optional<Catalog> optional = catalogRepo.findById(itemId);
        CatalogDTO catalogDTO = new CatalogDTO();
        modelMapper.map(optional.get(), catalogDTO);
        return catalogDTO;
    }

    public boolean checkItemAvailability(Long catalogId, Integer quantity) {
        if (!checkItemValidity(catalogId)) {
            return false;
        }
        Catalog catalog = catalogRepo.findById(catalogId).get();
        if (quantity > catalog.getStock()) {
            return false;
        }
        catalog.setStock(catalog.getStock() - quantity);
        return true;
    }

    public boolean checkItemValidity(Long catalogId) {
        Optional<Catalog> optional = catalogRepo.findById(catalogId);
        if (optional.isEmpty()) {
            return false;
        }
        return true;
    }

    public List<ReviewDTO> showReview(Long itemId) {
        Optional<Catalog> optional = catalogRepo.findById(itemId);
        if (optional.isEmpty()) {
            return null;
        }
        List<Review> reviews = optional.get().getReviews();
        List<ReviewDTO> reviewDTO_List = new ArrayList<>();
        for (Review review : reviews
        ) {
            ReviewDTO reviewDTO = new ReviewDTO();
            modelMapper.map(review, reviewDTO);
            reviewDTO_List.add(reviewDTO);
        }
        return reviewDTO_List;
    }

    public List<CatalogDTO> showItemsForUser(Long userId) {
        //check user exists from user microservice
        //if user doesn't exist return null

        List<Catalog> catalogs = catalogRepo.userSpecificItems();
        List<CatalogDTO> catalogDTOList = new ArrayList<>();
        for (Catalog catalog : catalogs
        ) {
            CatalogDTO catalogDTO = new CatalogDTO();
            modelMapper.map(catalog, catalogDTO);
            catalogDTOList.add(catalogDTO);
        }
        return catalogDTOList;
    }

    public OutputDTO addReview(Long itemId, Long userId, ReviewInputDTO reviewInputDTO) {
        if (!checkItemValidity(itemId)) {
            return new OutputDTO("invalid item", false);
        }
        //check user id valid
        //if not return new OutputDTO("invalid user", false);
        Review review = new Review();
        //review.setReviewId(1);
        review.setReviewContent(reviewInputDTO.getReviewContent());
        review.setUserId(userId);
        Catalog catalog = catalogRepo.findById(itemId).get();
        review.setCatalog(catalog);
        reviewRepo.save(review);
        return new OutputDTO(reviewInputDTO.getReviewContent() + " : this review added for item with Id " + itemId + " by user " + userId, true);
    }

    @Transactional
    public Catalog addItemBySeller(Catalog catalog, Integer sellerId) {
        //check if seller is valid
        //if it is not return new OutputDTO("you are not eligible to add item", false);


        catalog = catalogRepo.save(catalog);


        return catalog;
    }




    @Transactional
    public OutputDTO addItemInfoToItem(CatalogInfo catalogInfo, Integer sellerId, Long catalogId) {
        Optional<Catalog> optional= catalogRepo.findById(catalogId);



        Optional<CatalogInfo> catalogInfo1 = catalogInfoRepo.findById(catalogInfo.getCatalogInfoId());
        if (catalogInfo1.isEmpty()) {
            /*System.out.println("before save " + optional.get());*/
            catalogInfo = catalogInfoRepo.save(catalogInfo);
            /*System.out.println(catalogInfo);
            System.out.println("after save "+ optional.get());*/
        }
        try {
            /*System.out.println(optional.get());*/
            optional.get().setCatalogInfo(catalogInfo);
            /*System.out.println(optional.get());*/
            catalogRepo.save(optional.get());
            //return "pan card with ID "+ .getPanID()+"added successfully for student with ID "+ studentID;
        } catch (Exception ex) {
            //return "Error: pan card with ID "+ panCard.getPanID()+"cannot be added for student with ID "+ studentID+ " because "
            //        +ex.getMessage();        }

        }
        return null;
    }





    /*public OutputDTO addItemInfoToItem(CatalogInfoInputDTO catalogInfoInputDTO, Integer sellerId) {

        //System.out.println(catalog.getCatalogId() + "         *&^%%&(*&&**^&*&*(*");
        *//*CatalogInfo catalogInfo = new CatalogInfo();

        modelMapper.map(catalogInfoInputDTO, catalogInfo);
        catalogInfo.setCatalogInfoId(5l);
        System.out.println(catalogInfo.getCatalogInfoId());
        catalogInfo = catalogInfoRepo.save(catalogInfo);

        catalog.setCatalogInfo(catalogInfo);
        catalogRepo.save(catalog);

        CatalogInfo ct = catalogInfo;*//*
        Optional<Catalog> optional= catalogRepo.findById(5L);

        CatalogInfo catalogInfo = convertIntoCatalogInfo(catalogInfoInputDTO);


        Optional<CatalogInfo> catalogInfo1 = catalogInfoRepo.findById(catalogInfo.getCatalogInfoId());
        if (catalogInfo1.isEmpty()) {
            System.out.println("1"+optional.get());
            catalogInfo = catalogInfoRepo.save(catalogInfo);
            System.out.println(optional.get());
            System.out.println(catalogInfo.getCatalogInfoId());
        }
        try {

            System.out.println(optional.get());
            optional.get().setCatalogInfo(catalogInfo);
            System.out.println(optional.get());
            catalogRepo.save(optional.get());
            //return "pan card with ID "+ .getPanID()+"added successfully for student with ID "+ studentID;
        } catch (Exception ex) {
            //return "Error: pan card with ID "+ panCard.getPanID()+"cannot be added for student with ID "+ studentID+ " because "
            //        +ex.getMessage();        }

        }
        return null;
    }*/

    @Transactional
    private CatalogInfo convertIntoCatalogInfo(CatalogInfoInputDTO catalogInfoInputDTO) {
        CatalogInfo catalogInfo = new CatalogInfo();
        //modelMapper.map(catalogInfoInputDTO,catalogInfo);
        catalogInfo.setCatalogInfoId(catalogInfoInputDTO.getCatalogInfoId());
        catalogInfo.setColor(catalogInfoInputDTO.getColor());
        catalogInfo.setDiscount(catalogInfoInputDTO.getDiscount());
        catalogInfo.setGender(catalogInfoInputDTO.getGender());
        catalogInfo.setSize(catalogInfoInputDTO.getSize());
        catalogInfo.setPrice(catalogInfoInputDTO.getPrice());
        Brand brand = brandRepo.findById(catalogInfoInputDTO.getBrandId()).get();
        Category category = categoryRepo.findById(catalogInfoInputDTO.getCategoryId()).get();
        SubCategory subCategory = subCategoryRepo.findById(catalogInfoInputDTO.getSubCategoryId()).get();
        catalogInfo.setBrand(brand);
        catalogInfo.setCategory1(category);
        catalogInfo.setSubCategory(subCategory);

        return catalogInfo;
    }

    @Transactional
    public OutputDTO addItemInfoToItemDummy(CatalogInfoInputDTO catalogInfoInputDTO, Integer sellerId, Long catalogId) {
        CatalogInfo catalogInfo  =  convertIntoCatalogInfo(catalogInfoInputDTO);
        return addItemInfoToItem(catalogInfo, sellerId, catalogId);
    }

    public OutputDTO addItemBySellerDummy(CatalogInputDTO catalogInputDTO, Integer sellerId) {
        Catalog catalog = convertIntoCatalog(catalogInputDTO);
        catalog = addItemBySeller(catalog,sellerId);
        CatalogInfo catalogInfo= convertIntoCatalogInfo(catalogInputDTO.getCatalogInfoInputDTO());
        return addItemInfoToItem(catalogInfo, sellerId, catalog.getCatalogId());
    }

    private Catalog convertIntoCatalog(CatalogInputDTO catalogInputDTO) {
        Catalog catalog = new Catalog();
        catalog.setCatalogId(catalogInputDTO.getCatalogId());
        catalog.setCatalogDescription(catalogInputDTO.getCatalogDescription());
        catalog.setPrice(catalogInputDTO.getPrice());
        catalog.setStock(catalogInputDTO.getStock());
        catalog.setCOD_Availability(catalogInputDTO.getCod_Availability());
        return catalog;
    }
}

