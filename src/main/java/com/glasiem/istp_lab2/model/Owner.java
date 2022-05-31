package com.glasiem.istp_lab2.model;

import com.glasiem.istp_lab2.entity.ShopEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Owner {

    @Min(1)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String info;

    @NotNull
    @NotEmpty
    private ShopEntity shop;

    public Owner() {
    }

    public Owner(@NotNull @NotEmpty String name,
                      @NotNull @NotEmpty String info,
                      @NotNull @NotEmpty ShopEntity shop) {
        this.name = name;
        this.info = info;
        this.shop = shop;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }
}
