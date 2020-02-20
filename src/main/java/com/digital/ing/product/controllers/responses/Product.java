package com.digital.ing.product.controllers.responses;

public class Product {
    /**
     * ProductEntity ID
     */
    private Long id;

    /**
     * ProductEntity Name
     */
    private String name;

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
}
