package com.barbershop.manager.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_info_id", insertable = false, updatable = false)
    private Long customerInfoId;
    private Float totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "sale")
    private List<Product> products;

    @OneToMany(mappedBy = "sale")
    private List<BuyerInfo> buyerInfos;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(Long customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public List<BuyerInfo> getBuyerInfos() {
        return buyerInfos;
    }

    public void setBuyerInfos(List<BuyerInfo> buyerInfos) {
        this.buyerInfos = buyerInfos;
    }

    @PrePersist
    protected void onCreate() {
        Date currentDate = new Date();
        createdAt = currentDate;
        updatedAt = currentDate;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}

