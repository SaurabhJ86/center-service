package org.jhingan.productservice.controller;

import org.jhingan.productservice.dto.ProductRequestDTO;
import org.jhingan.productservice.dto.ProductResponseDTO;
import org.jhingan.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO productResponseDTO = this.productService.createProduct(productRequestDTO);
        return "Product has been saved with id " +  productResponseDTO.getProduct_id();
    }

}
