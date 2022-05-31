package com.glasiem.istp_lab2.entity;

import com.glasiem.istp_lab2.model.Shop;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ShopEntity extends Shop {

    public ShopEntity() {
        super();
    }

    public ShopEntity(@NotNull @NotEmpty String name,
                      @NotNull @NotEmpty String info,
                      @NotNull @NotEmpty String address) {
        super(name, info, address);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(length = 50, nullable = false, unique = false)
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Column(length = 500, nullable = false, unique = false)
    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public void setInfo(String info) {
        super.setInfo(info);
    }

    @Column(length = 500, nullable = false, unique = false)
    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }
}
