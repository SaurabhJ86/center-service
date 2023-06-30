package org.jhingan.productservice.service;

import org.jhingan.productservice.dto.ProductRequestDTO;
import org.jhingan.productservice.dto.ProductResponseDTO;
import org.jhingan.productservice.model.Product;
import org.jhingan.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setName(productRequestDTO.getName());

        Product savedProduct = this.productRepository.save(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProduct_id(savedProduct.getId());
        productResponseDTO.setName(savedProduct.getName());
        return productResponseDTO;
    }


}
