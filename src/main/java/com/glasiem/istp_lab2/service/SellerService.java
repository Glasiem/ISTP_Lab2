package com.glasiem.istp_lab2.service;

import com.glasiem.istp_lab2.entity.SellerEntity;
import com.glasiem.istp_lab2.model.Seller;
import com.glasiem.istp_lab2.repository.SellerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepo sellerRepo;

    public SellerRepo getSellerRepo() {
        return sellerRepo;
    }

    public int insertValid(Seller seller) {
        if (sellerRepo.findByContractNumber(seller.getContractNumber()) != null){
            return 1;
        }
        if (seller.getSalary() < 1){
            return 1;
        }
        sellerRepo.save(new SellerEntity(seller.getName(), seller.getInfo(), seller.getShop(), seller.getSalary(), seller.getContractNumber()));
        return 0;
    }

    public int updateValid(Seller seller) {
        if (sellerRepo.findByContractNumber(seller.getContractNumber()) != null &&
                sellerRepo.findByContractNumber(seller.getContractNumber()).getId() != seller.getId()){
            return 1;
        }
        if (seller.getSalary() < 1){
            return 1;
        }
        SellerEntity entity = sellerRepo.findById(seller.getId()).get();
        SellerEntity returnEntity = new SellerEntity(seller.getName(), seller.getInfo(), seller.getShop(), seller.getSalary(), seller.getContractNumber());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        sellerRepo.save(entity);
        return 0;
    }

    public int deleteValid(Long id) {
        if(sellerRepo.existsById(id)){
            sellerRepo.deleteById(id);
            return 0;
        }
        return 1;
    }
}
