package com.mstoppa.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"PRODUCT_ID", "STORE_ID"}))
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFER_SEQ")
    @SequenceGenerator(name = "OFFER_SEQ", sequenceName = "OFFER_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false)
    private Store store;

    @Column
    private Double price;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false)
    private boolean promotion;

    private Long productIdFromStore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public Long getProductIdFromStore() {
        return productIdFromStore;
    }

    public void setProductIdFromStore(Long productIdFromStore) {
        this.productIdFromStore = productIdFromStore;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", product=" + product +
                ", store=" + store +
                ", price=" + price +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        return id != null ? id.equals(offer.id) : offer.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
