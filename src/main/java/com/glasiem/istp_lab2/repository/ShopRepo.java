package com.glasiem.istp_lab2.repository;

import com.glasiem.istp_lab2.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends CrudRepository<ShopEntity,Long> {
    ShopEntity findByAddress(String address);
}
