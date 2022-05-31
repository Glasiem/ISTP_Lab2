package com.glasiem.istp_lab2.model;

import com.glasiem.istp_lab2.entity.DepartmentEntity;
import com.glasiem.istp_lab2.entity.ShopEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {

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
    private int quantity;

    @NotNull
    @NotEmpty
    private int price;

    @NotNull
    @NotEmpty
    private DepartmentEntity department;

    public Product() {
    }

    public Product(@NotNull @NotEmpty String name,
                   @NotNull @NotEmpty String info,
                   @NotNull @NotEmpty int quantity,
                   @NotNull @NotEmpty int price,
                   @NotNull @NotEmpty DepartmentEntity department) {
        this.name = name;
        this.info = info;
        this.quantity = quantity;
        this.price = price;
        this.department = department;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
