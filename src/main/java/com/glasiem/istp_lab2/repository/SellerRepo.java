package com.glasiem.istp_lab2.repository;

import com.glasiem.istp_lab2.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends CrudRepository<SellerEntity,Long> {
    SellerEntity findByContractNumber(String contractNumber);
}
