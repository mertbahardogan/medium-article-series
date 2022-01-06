package com.microservices.project.product.business.abstracts;

import com.microservices.project.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(String id);
    Product create(Product newProduct);
    Product update(String id,Product newProduct);
    boolean delete(String id);
    Product updateTitle(String id,String title);
}
