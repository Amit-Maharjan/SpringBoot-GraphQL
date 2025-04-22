package com.maharjan.amit.SpringBoot_GraphQL.services;

import com.maharjan.amit.SpringBoot_GraphQL.entities.Product;
import com.maharjan.amit.SpringBoot_GraphQL.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // SALES TEAM: Update the stock of a product
    public Product updateStock(int id, int stock) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setStock(stock);
        return productRepository.save(existingProduct);
    }

    // WAREHOUSE TEAM: Receive new shipment
    public Product receiveNewShipment(int id, int quantity) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existingProduct.setStock(existingProduct.getStock() + quantity);
        return productRepository.save(existingProduct);
    }
}
