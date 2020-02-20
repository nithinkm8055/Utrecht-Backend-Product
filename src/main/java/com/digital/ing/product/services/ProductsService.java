package com.digital.ing.product.services;

import com.digital.ing.product.controllers.responses.*;
import com.digital.ing.product.exceptions.ApiError;
import com.digital.ing.product.exceptions.ApiException;
import com.digital.ing.product.repositories.*;
import com.digital.ing.product.repositories.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    MortgageProductRepository mortgageProductRepository;

    @Autowired
    PaymentsProductRepository paymentsProductRepository;

    @Autowired
    SavingsProductRepository savingsProductRepository;

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

    public ProductDetailsResponse getProductDetails(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST,"Unable to find the product for provided ID",""));
        switch (productEntity.getProductGroupEntity().getId().intValue()) {
            case 1: MortgageProductEntity mortgageProductEntity = mortgageProductRepository.findByProductEntity(productEntity).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST,"Unable to find the product details for provided ID",""));
                    return mapEntityToResponse(mortgageProductEntity);
            case 2: PaymentsProductEntity paymentsProductEntity = paymentsProductRepository.findByProductEntity(productEntity).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST,"Unable to find the product details for provided ID",""));
                return mapEntityToResponse(paymentsProductEntity);
            case 3: SavingsProductEntity savingsProductEntity = savingsProductRepository.findByProductEntity(productEntity).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST,"Unable to find the product details for provided ID",""));
                return mapEntityToResponse(savingsProductEntity);
            default:
                throw new ApiException(HttpStatus.BAD_REQUEST,"Unable to find the product for provided ID","");
        }
    }

    private MortgageProductResponse mapEntityToResponse(MortgageProductEntity mortgageProductEntity) {
        MortgageProductResponse response = new MortgageProductResponse();
        response.setAccountNumber(mortgageProductEntity.getAccountNumber());
        response.setRemainingMortgage(mortgageProductEntity.getRemainingMortgage());
        response.setProductId(mortgageProductEntity.getProductEntity().getId());
        return response;
    }

    private PaymentProductResponse mapEntityToResponse(PaymentsProductEntity paymentsProductEntity) {
        PaymentProductResponse response = new PaymentProductResponse();
        response.setAccountNumber(paymentsProductEntity.getAccountNumber());
        response.setLimit(paymentsProductEntity.getAccountLimit());
        response.setProductId(paymentsProductEntity.getProductEntity().getId());
        return response;
    }

    private SavingProductResponse mapEntityToResponse(SavingsProductEntity savingsProductEntity) {
        SavingProductResponse response = new SavingProductResponse();
        response.setAccountNumber(savingsProductEntity.getAccountNumber());
        response.setTotalAmount(savingsProductEntity.getAccountBalance());
        response.setProductId(savingsProductEntity.getProductEntity().getId());
        return response;
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
