package com.example.produitcategory.mappers;

import com.example.produitcategory.DTO.CategoryDTO;
import com.example.produitcategory.DTO.ProductDTO;
import com.example.produitcategory.entities.Category;
import com.example.produitcategory.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CatalogMappers {
    public ProductDTO fromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        productDTO.setCategoryDTO(fromCategory(product.getCategory()));
        return productDTO;
    }

    public Product fromProductDTO(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setCategory((fromCategoryDTO(productDTO.getCategoryDTO())));
        return product;
    }

    public CategoryDTO fromCategory(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category, categoryDTO);
        return categoryDTO;
    }

    public Category fromCategoryDTO(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        return category;
    }
}
