package com.glasiem.istp_lab2.service;

import com.glasiem.istp_lab2.entity.OwnerEntity;
import com.glasiem.istp_lab2.entity.SellerEntity;
import com.glasiem.istp_lab2.model.Owner;
import com.glasiem.istp_lab2.model.Seller;
import com.glasiem.istp_lab2.repository.OwnerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    OwnerRepo ownerRepo;

    public OwnerRepo getOwnerRepo() {
        return ownerRepo;
    }

    public int insertValid(Owner owner) {
        if (ownerRepo.findByShop_Id(owner.getShop().getId()) != null){
            return 1;
        }
        ownerRepo.save(new OwnerEntity(owner.getName(), owner.getInfo(), owner.getShop()));
        return 0;
    }

    public int updateValid(Owner owner) {
        if (ownerRepo.findByShop_Id(owner.getShop().getId()) != null &&
                ownerRepo.findByShop_Id(owner.getShop().getId()).getId() != owner.getId()){
            return 1;
        }
        OwnerEntity entity = ownerRepo.findById(owner.getId()).get();
        OwnerEntity returnEntity = new OwnerEntity(owner.getName(), owner.getInfo(), owner.getShop());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        ownerRepo.save(entity);
        return 0;
    }

    public int deleteValid(Long id) {
        if(ownerRepo.existsById(id)){
            ownerRepo.deleteById(id);
            return 0;
        }
        return 1;
    }
}
