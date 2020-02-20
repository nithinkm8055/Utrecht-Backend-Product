package com.digital.ing.product.controllers;

import com.digital.ing.product.controllers.responses.ProductGroupResponse;
import com.digital.ing.product.services.ProductsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

    @Mock
    ProductsService productsService;

    @InjectMocks
    ProductsController productsController;

    @Test
    public void getAllProductGroups_whenCalled_shouldCallService(){
        when(productsService.getAllProducts()).thenReturn(new ProductGroupResponse());

        productsController.getAllProductGroups();

        verify(productsService, times(1)).getAllProducts();
    }
}
