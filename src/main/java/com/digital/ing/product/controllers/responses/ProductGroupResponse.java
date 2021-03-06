package com.digital.ing.product.controllers.responses;

import java.util.List;

public class ProductGroupResponse {
    /**
     * List of all product groups
     */
    private List<ProductGroup> productGroups;

    public List<ProductGroup> getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(List<ProductGroup> productGroups) {
        this.productGroups = productGroups;
    }
}
