package com.digital.ing.product.controllers.responses;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
public class ProductGroup {

    /**
     * Product Group ID
     */
    private Long id;

    /**
     * Product Group Name
     */
    private String name;

    /**
     * List of all products in this product group
     */
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
