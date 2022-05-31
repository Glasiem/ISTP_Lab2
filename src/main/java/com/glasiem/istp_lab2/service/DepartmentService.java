package com.glasiem.istp_lab2.service;

import com.glasiem.istp_lab2.entity.DepartmentEntity;
import com.glasiem.istp_lab2.model.Department;
import com.glasiem.istp_lab2.repository.DepartmentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    public DepartmentRepo getDepartmentRepo() {
        return departmentRepo;
    }

    public int insertValid(Department department) {
        if (departmentRepo.findByNameAndShop_Id(department.getName(), department.getShop().getId()) != null){
            return 1;
        }
        departmentRepo.save(new DepartmentEntity(department.getName(), department.getInfo(), department.getShop()));
        return 0;
    }

    public int updateValid(Department department) {
        if (departmentRepo.findByNameAndShop_Id(department.getName(), department.getShop().getId()) != null &&
                departmentRepo.findByNameAndShop_Id(department.getName(), department.getShop().getId()).getId() != department.getId()){
            return 1;
        }
        DepartmentEntity entity = departmentRepo.findById(department.getId()).get();
        DepartmentEntity returnEntity = new DepartmentEntity(department.getName(), department.getInfo(), department.getShop());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        departmentRepo.save(entity);
        return 0;
    }

    public int deleteValid(Long id) {
        if(departmentRepo.existsById(id)){
            departmentRepo.deleteById(id);
            return 0;
        }
        return 1;
    }
}
