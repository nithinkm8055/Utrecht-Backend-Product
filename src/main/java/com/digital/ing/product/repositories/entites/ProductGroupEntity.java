package com.digital.ing.product.repositories.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Product_Group")
public class ProductGroupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ProductEntity> productEntities = new ArrayList<>();

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

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}
	
	
}
