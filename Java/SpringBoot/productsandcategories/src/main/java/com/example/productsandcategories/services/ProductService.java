package com.example.productsandcategories.services;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.repositories.categoryRepository;
import com.example.productsandcategories.repositories.productRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final productRepository prodrepo;
    private final categoryRepository catrepo;

    public ProductService(productRepository prodrepo, categoryRepository catrepo) {
        this.prodrepo = prodrepo;
        this.catrepo = catrepo;
    }

    public List<Category> getCategoriesNotIn(Long id) {
        return catrepo.getAllnotIn(id);
    }

    public Product getProductById(Long id) {
        Optional<Product> product = prodrepo.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            return null;
        }
    }


    public Product createProduct(Product p) {

        prodrepo.save(p);
        return p;
    }

    public void addcat(Long categoryid, Long prodid) {

        Optional<Category> categories = catrepo.findById(categoryid);
        if (categories.isPresent()) {
            Category category = categories.get();
            Product product = getProductById(prodid);
            product.getCategories().add(category);
            prodrepo.save(product);
        } else {
            System.out.println("Error getting Category with id:" + categoryid);
        }


    }
}
