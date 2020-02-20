package com.digital.ing.product.services;

import com.digital.ing.product.controllers.responses.Product;
import com.digital.ing.product.controllers.responses.ProductGroup;
import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import com.digital.ing.product.repositories.entites.ProductEntity;
import com.digital.ing.product.repositories.entites.ProductGroupEntity;
import com.digital.ing.product.repositories.ProductGroupRepository;
import com.digital.ing.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    ProductGroupRepository productGroupRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductGroupResponse getAllProducts(){
        ProductGroupResponse productGroupResponse = new ProductGroupResponse();
        List<ProductGroup> productGroupList = new ArrayList<>();
        productGroupRepository.findAll().forEach((data)->{
            ProductGroup productGroup = mapEntityToResponse(data);
            productGroup.setProducts(productRepository.findAllByProductGroupEntity(data).stream().map(this::mapEntityToResponse).collect(Collectors.toList()));
            productGroupList.add(productGroup);
        });
        productGroupResponse.setProductGroups(productGroupList);
        return productGroupResponse;
    }

    private ProductGroup mapEntityToResponse(ProductGroupEntity productGroupEntity) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(productGroupEntity.getId());
        productGroup.setName(productGroupEntity.getName());
        return productGroup;
    }

    private Product mapEntityToResponse(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getProductName());
        return product;
    }
}
