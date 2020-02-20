package com.digital.ing.product.repositories.entites;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByProductGroupEntity(ProductGroupEntity productGroupEntity);
}
