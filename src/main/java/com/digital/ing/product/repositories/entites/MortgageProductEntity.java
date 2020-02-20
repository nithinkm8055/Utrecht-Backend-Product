package com.digital.ing.product.repositories.entites;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "mortgage_product")
public class MortgageProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private ProductEntity productEntity;
	
	private BigDecimal remainingMortgage;
	
	private String accountNumber;

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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
}
