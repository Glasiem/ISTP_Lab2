package com.glasiem.istp_lab2.entity;

import com.glasiem.istp_lab2.model.Seller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class SellerEntity extends Seller {

    public SellerEntity() {
        super();
    }

    public SellerEntity(@NotNull @NotEmpty String name,
                        @NotNull @NotEmpty String info,
                        @NotNull @NotEmpty ShopEntity shop,
                        @NotNull @NotEmpty int salary,
                        @NotNull @NotEmpty String contract_number) {
        super(name, info, shop, salary, contract_number);
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

    @ManyToOne
    @Override
    public ShopEntity getShop() {
        return super.getShop();
    }

    @Override
    public void setShop(ShopEntity shop) {
        super.setShop(shop);
    }

    @Column(nullable = false, unique = false)
    @Override
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    @Column(nullable = false, unique = true)
    @Override
    public String getContractNumber() {
        return super.getContractNumber();
    }

    @Override
    public void setContractNumber(String contractNumber) {
        super.setContractNumber(contractNumber);
    }
}
