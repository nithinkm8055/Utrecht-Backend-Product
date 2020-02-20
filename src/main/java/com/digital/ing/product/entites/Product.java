package com.digital.ing.product.entites;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private ProductGroup productGroup;
		
		private String productName;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public ProductGroup getProductGroup() {
			return productGroup;
		}

		public void setProductGroup(ProductGroup productGroup) {
			this.productGroup = productGroup;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

}
