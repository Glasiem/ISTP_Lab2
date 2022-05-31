package com.glasiem.istp_lab2.repository;

import com.glasiem.istp_lab2.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends CrudRepository<DepartmentEntity,Long> {
    DepartmentEntity findByNameAndShop_Id(String name, Long id);
}
