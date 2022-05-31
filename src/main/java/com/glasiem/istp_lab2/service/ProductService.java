package com.glasiem.istp_lab2.service;

import com.glasiem.istp_lab2.entity.ProductEntity;
import com.glasiem.istp_lab2.entity.SellerEntity;
import com.glasiem.istp_lab2.model.Product;
import com.glasiem.istp_lab2.model.Seller;
import com.glasiem.istp_lab2.repository.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public int insertValid(Product product) {
        if (productRepo.findByNameAndInfoAndDepartment_Id(product.getName(), product.getInfo(), product.getDepartment().getId()) != null){
            return 1;
        }
        if (product.getPrice() < 1 || product.getQuantity() < 0){
            return 1;
        }
        productRepo.save(new ProductEntity(product.getName(), product.getInfo(), product.getQuantity(), product.getPrice(), product.getDepartment()));
        return 0;
    }

    public int updateValid(Product product) {
        if (productRepo.findByNameAndInfoAndDepartment_Id(product.getName(), product.getInfo(), product.getDepartment().getId()) != null &&
                productRepo.findByNameAndInfoAndDepartment_Id(product.getName(), product.getInfo(), product.getDepartment().getId()).getId() != product.getId()){
            return 1;
        }
        if (product.getPrice() < 1 || product.getQuantity() < 0){
            return 1;
        }
        ProductEntity entity = productRepo.findById(product.getId()).get();
        ProductEntity returnEntity = new ProductEntity(product.getName(), product.getInfo(), product.getQuantity(), product.getPrice(), product.getDepartment());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        productRepo.save(entity);
        return 0;
    }

    public int deleteValid(Long id) {
        if(productRepo.existsById(id)){
            productRepo.deleteById(id);
            return 0;
        }
        return 1;
    }
}
