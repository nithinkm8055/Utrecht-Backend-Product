package com.digital.ing.product.controllers.responses;

import java.math.BigDecimal;

public class SavingProductResponse implements ProductDetailsResponse {

    /**
     * Product ID
     */
    private Long productId;

    /**
     * Total Amount
     */
    private BigDecimal totalAmount;

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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
