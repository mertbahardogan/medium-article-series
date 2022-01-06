package com.microservices.project.product.business.concretes;

import com.microservices.project.product.business.abstracts.ProductService;
import com.microservices.project.product.dataAccess.ProductDAO;
import com.microservices.project.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductManager(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return this.productDAO.findById(id);
    }

    @Override
    public Product create(Product newProduct) {
        return this.productDAO.save(newProduct);
    }

    @Override
    public Product update(String id,Product oldProduct) {
        Product newProduct=this.productDAO.findById(id).get();
        newProduct.setTitle(oldProduct.getTitle());
        newProduct.setPrice(oldProduct.getPrice());
        newProduct.setQuantity(oldProduct.getQuantity());
        return this.productDAO.save(newProduct);
    }

    @Override
    public boolean delete(String id) {
        this.productDAO.deleteById(id);
        return true;
    }

    @Override
    public Product updateTitle(String id,String title) {
        Product newProduct=this.productDAO.findById(id).get();
        System.out.println(newProduct);
        newProduct.setTitle(title);
        return this.productDAO.save(newProduct);
    }
}
