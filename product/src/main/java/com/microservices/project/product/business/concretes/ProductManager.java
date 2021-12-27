package com.microservices.project.product.business.concretes;

import com.microservices.project.product.business.abstracts.ProductService;
import com.microservices.project.product.dataAccess.ProductDAO;
import com.microservices.project.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductManager implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductManager(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
