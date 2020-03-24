package com.example.usermanagementrestapi.service;

import com.example.usermanagementrestapi.entity.Product;
import com.example.usermanagementrestapi.model.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDto> getListProduct();

    ProductDto getProductById(int productId);

    List<ProductDto> getListProductNew();

    Product getOne(int productId);

    void deleteProduct(int productId);

    ProductDto updateProduct(ProductDto productDto, int productId);

    Page<Product> getListProductByCategoryOrProductNameContaining(Pageable pageable,
                                                                  @Param("categoryId") Integer categoryId,
                                                                  @Param("productName") String productName);

    //Test api
    ProductDto createProduct(ProductDto productDto);
}
