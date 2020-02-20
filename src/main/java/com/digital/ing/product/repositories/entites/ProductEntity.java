package com.digital.ing.product.repositories.entites;
import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private ProductGroupEntity productGroupEntity;
		
		private String productName;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public ProductGroupEntity getProductGroupEntity() {
			return productGroupEntity;
		}

		public void setProductGroupEntity(ProductGroupEntity productGroupEntity) {
			this.productGroupEntity = productGroupEntity;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

}
