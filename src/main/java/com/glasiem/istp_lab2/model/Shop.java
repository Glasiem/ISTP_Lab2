package com.glasiem.istp_lab2.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Shop {

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
    private String address;

    public Shop() {
    }

    public Shop(@NotNull @NotEmpty String name,
                @NotNull @NotEmpty String info,
                @NotNull @NotEmpty String address) {
        this.name = name;
        this.info = info;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
