package com.digital.ing.product.repositories.entites;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MortgageProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private ProductEntity productEntity;
	
	private BigDecimal remainingMortgage;
	
	private int accountNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public BigDecimal getRemainingMortgage() {
		return remainingMortgage;
	}

	public void setRemainingMortgage(BigDecimal remainingMortgage) {
		this.remainingMortgage = remainingMortgage;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
}
