package com.digital.ing.product.repositories;

import com.digital.ing.product.repositories.entites.MortgageProductEntity;
import com.digital.ing.product.repositories.entites.ProductEntity;
import com.digital.ing.product.repositories.entites.SavingsProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingsProductRepository extends CrudRepository<SavingsProductEntity, Long> {
    Optional<SavingsProductEntity> findByProductEntity(ProductEntity productEntity);
}
