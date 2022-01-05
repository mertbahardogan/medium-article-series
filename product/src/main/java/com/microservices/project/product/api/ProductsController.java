package com.microservices.project.product.api;

import com.microservices.project.product.business.abstracts.ProductService;
import com.microservices.project.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Product newProduct) {
        return new ResponseEntity<>(this.productService.create(newProduct), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody Product newProduct,@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(this.productService.update(newProduct,id), HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity updateTitle(@RequestBody String title,@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(this.productService.updateTitle(title,id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
