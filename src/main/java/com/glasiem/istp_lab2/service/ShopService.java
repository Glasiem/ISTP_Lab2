package com.glasiem.istp_lab2.service;

import com.glasiem.istp_lab2.entity.ShopEntity;
import com.glasiem.istp_lab2.model.Shop;
import com.glasiem.istp_lab2.repository.ShopRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    ShopRepo shopRepo;

    @Autowired
    DepartmentService departmentRepo;

    public ShopRepo getShopRepo() {
        return shopRepo;
    }

    public int insertValid(Shop shop) {
        if (shopRepo.findByAddress(shop.getAddress()) != null){
            return 1;
        }
        shopRepo.save(new ShopEntity(shop.getName(), shop.getInfo(), shop.getAddress()));
        return 0;
    }

    public int updateValid(Shop shop) {
        if (shopRepo.findByAddress(shop.getAddress()) != null &&
                shopRepo.findByAddress(shop.getAddress()) != shop){
            return 1;
        }
        ShopEntity entity = shopRepo.findById(shop.getId()).get();
        ShopEntity returnEntity = new ShopEntity(shop.getName(), shop.getInfo(), shop.getAddress());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        shopRepo.save(entity);
        return 0;
    }

    public int deleteValid(Long id) {
        if(shopRepo.existsById(id)){
            shopRepo.deleteById(id);
            return 0;
        }
        return 1;
    }
}
