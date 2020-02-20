package com.digital.ing.product.repositories;

import com.digital.ing.product.repositories.entites.MortgageProductEntity;
import com.digital.ing.product.repositories.entites.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MortgageProductRepository extends CrudRepository<MortgageProductEntity, Long> {

    Optional<MortgageProductEntity> findByProductEntity(ProductEntity productEntity);
}
