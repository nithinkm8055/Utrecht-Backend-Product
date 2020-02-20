package com.digital.ing.product.services;

import com.digital.ing.product.controllers.responses.Product;
import com.digital.ing.product.controllers.responses.ProductGroup;
import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    public ProductGroupResponse getAllProducts(){
        return createProductResponse();
    }

    //TODO :: Temporary response will be removed
    private ProductGroupResponse createProductResponse() {
        ProductGroupResponse productGroupResponse = new ProductGroupResponse();
        ProductGroup productGroup = new ProductGroup();
        productGroup.setName("Savings");
        productGroup.setId(1L);
        Product product = new Product();
        product.setId(1L);
        product.setName("Oranjespaarenkening");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        product = new Product();
        product.setId(2L);
        product.setName("Bonusrenterekening");
        productList.add(product);
        productGroup.setProducts(productList);
        List<ProductGroup> productGroupList = new ArrayList<>();
        productGroupList.add(productGroup);
        productGroupResponse.setProductGroups(productGroupList);

        return productGroupResponse;
    }
}
