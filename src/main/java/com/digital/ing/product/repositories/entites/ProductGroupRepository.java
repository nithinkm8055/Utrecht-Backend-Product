package com.digital.ing.product.repositories.entites;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroupEntity, Long> {
}
