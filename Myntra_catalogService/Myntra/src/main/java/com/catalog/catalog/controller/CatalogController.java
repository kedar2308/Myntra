package com.catalog.catalog.controller;

import com.catalog.catalog.DTO.*;
import com.catalog.catalog.entity.Catalog;
import com.catalog.catalog.entity.CatalogInfo;
import com.catalog.catalog.entity.Review;
import com.catalog.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class CatalogController {

    @Autowired
    CatalogService catalogService;


    @GetMapping("/item/valid/{itemId}")
    public boolean checkItemValidity(@PathVariable ("itemId") Long catalogId){
        boolean isValid = catalogService.checkItemValidity(catalogId);
        return isValid;
    }

    @GetMapping("/item/available/{itemId}/{quantity}")
    public boolean checkItemAvailability(@PathVariable ("itemId") Long catalogId,@PathVariable ("quantity") Integer quantity){
        boolean isAvailable = catalogService.checkItemAvailability(catalogId,quantity);
        return isAvailable;
    }

    @GetMapping("/view/item/{itemId}")
    public CatalogDTO showItem(@PathVariable ("itemId") Long catalogId){
        CatalogDTO catalogDTO = catalogService.showItem(catalogId);
        return catalogDTO;
    }

    @Transactional
    @GetMapping("/view/reviews/{itemId}")
    public List<ReviewDTO> showReview(@PathVariable ("itemId") Long itemId){
        List<ReviewDTO> reviews = catalogService.showReview(itemId);
        return reviews;
    }


    @Transactional
    @GetMapping("/view/item/user/{userId}")
    public List<CatalogDTO> showItemsForUser(@PathVariable ("userId") Long userId){


        List<CatalogDTO> catalogDTOList = catalogService.showItemsForUser(userId);
        return catalogDTOList;
    }

    @Transactional
    @PostMapping("/add/review/item/{itemId}/user/{userId}")
    public OutputDTO addReview(@PathVariable ("itemId") Long itemId, @PathVariable ("userId") Long userId, @RequestBody ReviewInputDTO reviewInputDTO){

        OutputDTO outputDTO = catalogService.addReview(itemId,userId,reviewInputDTO);
        return outputDTO;
    }

    @Transactional
    @PostMapping("/add/item/{sellerId}")
    public OutputDTO addItemBySeller(@RequestBody CatalogInputDTO catalogInputDTO, @PathVariable ("sellerId") Integer sellerId){


        OutputDTO outputDTO = catalogService.addItemBySellerDummy(catalogInputDTO,sellerId);
        return outputDTO;
    }

    /*@Transactional
    @PutMapping("/add/item/{sellerId}")
    public OutputDTO updateItemBySeller(@RequestBody CatalogInfoInputDTO catalogInfoInputDTO, @PathVariable ("sellerId") Integer sellerId){

        OutputDTO outputDTO = catalogService.addItemInfoToItem(catalogInfoInputDTO,sellerId);
        return outputDTO;
    }*/

    /*@Transactional
    @PutMapping("/add/item/{sellerId}")
    public OutputDTO updateItemBySeller(@PathVariable ("sellerId") Integer sellerId){

        OutputDTO outputDTO = catalogService.addItemInfoToItem(sellerId);
        return outputDTO;
    }*/

    @Transactional
    @PutMapping("/add/item/catalogInfo/{sellerId}")
    public OutputDTO updateItemBySeller(@RequestBody CatalogInfoInputDTO catalogInfo,@PathVariable ("sellerId") Integer sellerId){

        OutputDTO outputDTO = catalogService.addItemInfoToItemDummy(catalogInfo,sellerId,6l);
        return outputDTO;
    }
}
