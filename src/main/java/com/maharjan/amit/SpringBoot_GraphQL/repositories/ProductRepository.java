package com.maharjan.amit.SpringBoot_GraphQL.repositories;

import com.maharjan.amit.SpringBoot_GraphQL.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
}
