package com.example.produitcategory.repositories;

import com.example.produitcategory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
