package com.microservices.project.product.business.concretes;

import com.microservices.project.product.dataAccess.ProductDAO;
import com.microservices.project.product.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @InjectMocks
    private ProductManager productManager;

    @Mock
    private ProductDAO productDAO;

    @Test
    public void givenProduct_whenCreate_thenReturnProduct() {
        Product productObject = new Product();
        productObject.setId(UUID.randomUUID().toString());
        productObject.setTitle("iPhone 13");
        productObject.setPrice(new BigDecimal("1.000"));
        productObject.setQuantity(3000);

        Product filmMock = Mockito.mock(Product.class);
        when(productDAO.save(ArgumentMatchers.any(Product.class))).thenReturn(filmMock);
        Product result = productManager.create(productObject);

        assertEquals(result,productObject);
    }
}