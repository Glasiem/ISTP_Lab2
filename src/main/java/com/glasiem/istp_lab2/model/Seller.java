package com.glasiem.istp_lab2.model;

import com.glasiem.istp_lab2.entity.ShopEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Seller {

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
    private int salary;

    @NotNull
    @NotEmpty
    private ShopEntity shop;

    @NotNull
    @NotEmpty
    private String contractNumber;

    public Seller() {
    }

    public Seller(@NotNull @NotEmpty String name,
                   @NotNull @NotEmpty String info,
                   @NotNull @NotEmpty ShopEntity shop,
                   @NotNull @NotEmpty int salary,
                   @NotNull @NotEmpty String contractNumber) {
        this.name = name;
        this.info = info;
        this.shop = shop;
        this.salary = salary;
        this.contractNumber = contractNumber;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
}
