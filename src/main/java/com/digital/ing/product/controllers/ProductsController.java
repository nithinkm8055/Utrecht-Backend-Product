package com.digital.ing.product.controllers;

import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/product-groups")
    public ProductGroupResponse getAllProductGroups(){
        return new ProductGroupResponse();
    }


}
