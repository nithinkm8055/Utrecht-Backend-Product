package com.digital.ing.product.controllers.responses;

import java.math.BigDecimal;

public class MortgageProductResponse implements ProductDetailsResponse {

    /**
     * Product ID
     */
    private Long productId;

    /**
     * Remaining Mortgage
     */
    private BigDecimal remainingMortgage;

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

    public BigDecimal getRemainingMortgage() {
        return remainingMortgage;
    }

    public void setRemainingMortgage(BigDecimal remainingMortgage) {
        this.remainingMortgage = remainingMortgage;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
