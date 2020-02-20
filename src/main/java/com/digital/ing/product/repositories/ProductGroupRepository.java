package com.digital.ing.product.repositories;

import com.digital.ing.product.repositories.entites.ProductGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroupEntity, Long> {
}
