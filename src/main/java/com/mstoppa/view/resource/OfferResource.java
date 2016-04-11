package com.mstoppa.view.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mstoppa.model.Product;
import com.mstoppa.model.Store;

import java.math.BigDecimal;

public class OfferResource {

    @JsonIgnore
    private Long id;

    private Long productIdFromStore;

    private Product product;

    private Store store;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
    private Double price;

    private boolean available;

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductIdFromStore() {
        return productIdFromStore;
    }

    public void setProductIdFromStore(Long productIdFromStore) {
        this.productIdFromStore = productIdFromStore;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
