package com.microservices.project.product.business.abstracts;

import com.microservices.project.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();
}
