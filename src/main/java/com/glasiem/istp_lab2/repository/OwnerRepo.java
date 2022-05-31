package com.glasiem.istp_lab2.repository;

import com.glasiem.istp_lab2.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends CrudRepository<OwnerEntity,Long> {
    OwnerEntity findByShop_Id (Long id);
}
