package com.digital.ing.product.controllers.responses;

import java.math.BigDecimal;

public class PaymentProductResponse implements ProductDetailsResponse {

    /**
     * Product ID
     */
    private Long productId;

    /**
     * Limit
     */
    private BigDecimal limit;

    /**
     * Account number
     */
    private String accountNumber;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
