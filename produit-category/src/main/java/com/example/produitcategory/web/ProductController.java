package com.example.produitcategory.web;

import com.example.produitcategory.DTO.ProductDTO;
import com.example.produitcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> productList() {
        return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable String id) {
        productDTO.setId(id);
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}


