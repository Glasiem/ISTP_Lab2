package com.glasiem.istp_lab2.entity;

import com.glasiem.istp_lab2.model.Product;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ProductEntity extends Product {

    public ProductEntity() {
        super();
    }

    public ProductEntity(@NotNull @NotEmpty String name,
                         @NotNull @NotEmpty String info,
                         @NotNull @NotEmpty int quantity,
                         @NotNull @NotEmpty int price,
                         @NotNull @NotEmpty DepartmentEntity department) {
        super(name, info, quantity, price, department);
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

    @Column(nullable = false, unique = false)
    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Column(nullable = false, unique = false)
    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @ManyToOne
    @Override
    public DepartmentEntity getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setDepartment(DepartmentEntity department) {
        super.setDepartment(department);
    }
}
