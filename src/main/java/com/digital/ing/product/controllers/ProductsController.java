package com.digital.ing.product.controllers;

import com.digital.ing.product.controllers.responses.MortgageProductResponse;
import com.digital.ing.product.controllers.responses.ProductDetailsResponse;
import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import com.digital.ing.product.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/product-groups")
    public ProductGroupResponse getAllProductGroups(){
        return productsService.getAllProducts();
    }

    @GetMapping("/product-groups/products/{productId}")
    public ProductDetailsResponse getProductDetails(@RequestParam("productId") Long productId){
        return new MortgageProductResponse();
    }


}
