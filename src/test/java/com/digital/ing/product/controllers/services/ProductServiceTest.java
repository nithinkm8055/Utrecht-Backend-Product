package com.digital.ing.product.controllers.services;

import com.digital.ing.product.controllers.ProductsController;
import com.digital.ing.product.controllers.responses.ProductGroup;
import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import com.digital.ing.product.repositories.ProductGroupRepository;
import com.digital.ing.product.repositories.ProductRepository;
import com.digital.ing.product.repositories.entites.ProductGroupEntity;
import com.digital.ing.product.services.ProductsService;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;


    @Mock
    ProductGroupRepository productGroupRepository;


    @InjectMocks
    ProductsService productsService;

    @Test
    public void getAllProductGroups_whenCalled_shouldCallRepositoryToFetchGroups(){
        when(productGroupRepository.findAll()).thenReturn(new ArrayIterator<>(new ProductGroupEntity[0]));

        productsService.getAllProducts();

        verify(productGroupRepository, times(1)).findAll();
    }

    @Test
    public void getAllProductGroups_whenCalled_shouldCallRepositoryToFetchProducts(){
        ProductGroupEntity productGroupEntity = new ProductGroupEntity();
        productGroupEntity.setId(1L);
        productGroupEntity.setName("Product Group Name");
        when(productGroupRepository.findAll()).thenReturn(new ArrayIterator<>(new ProductGroupEntity[]{productGroupEntity}));

        productsService.getAllProducts();

        ArgumentCaptor<ProductGroupEntity> argumentCaptor = ArgumentCaptor.forClass(ProductGroupEntity.class);
        verify(productRepository, times(1)).findAllByProductGroupEntity(argumentCaptor.capture());
        ProductGroupEntity actualProductGroupEntity = argumentCaptor.getValue();
        assertEquals(1L, actualProductGroupEntity.getId());
    }
}
