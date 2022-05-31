package com.glasiem.istp_lab2.entity;

import com.glasiem.istp_lab2.model.Owner;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class OwnerEntity extends Owner {

    public OwnerEntity() {
        super();
    }

    public OwnerEntity(@NotNull @NotEmpty String name,
                            @NotNull @NotEmpty String info,
                            @NotNull @NotEmpty ShopEntity shop) {
        super(name, info, shop);
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

    @OneToOne
    @Override
    public ShopEntity getShop() {
        return super.getShop();
    }

    @Override
    public void setShop(ShopEntity shop) {
        super.setShop(shop);
    }
}
