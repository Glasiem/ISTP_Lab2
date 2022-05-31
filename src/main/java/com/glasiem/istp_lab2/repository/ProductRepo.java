package com.glasiem.istp_lab2.repository;

import com.glasiem.istp_lab2.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<ProductEntity,Long> {
    ProductEntity findByNameAndInfoAndDepartment_Id(String name, String info, Long id);
}
