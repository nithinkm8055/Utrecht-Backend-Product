package com.digital.ing.product.entites;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PaymentsProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private Product product;
	
	private BigDecimal accountLimit;
	
	private int accountNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getAccountLimit() {
		return accountLimit;
	}

	public void setAccountLimit(BigDecimal accountLimit) {
		this.accountLimit = accountLimit;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
