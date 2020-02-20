package com.digital.ing.product.controllers;

import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import com.digital.ing.product.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/product-groups")
    public ProductGroupResponse getAllProductGroups(){
        return productsService.getAllProducts();
    }


}
