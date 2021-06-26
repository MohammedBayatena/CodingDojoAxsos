package com.example.productsandcategories.services;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.repositories.categoryRepository;
import com.example.productsandcategories.repositories.productRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final categoryRepository catrepo;
    private final productRepository prodrepo;

    public CategoryService(categoryRepository catrepo, productRepository prodrepo) {
        this.catrepo = catrepo;
        this.prodrepo = prodrepo;
    }

    public Category createCategory(Category c) {
        catrepo.save(c);
        return c;
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category = catrepo.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            return null;
        }
    }

    public List<Product> getPrdocutsNotIn(Long id) {
        return prodrepo.getAllnotIn(id);
    }

    public void addprod(Long productid, Long catid) {

        Optional<Product> products = prodrepo.findById(productid);
        if (products.isPresent()) {
            Product product = products.get();
            Category category = getCategoryById(catid);
            category.getProducts().add(product);
            catrepo.save(category);
        } else {
            System.out.println("Error Adding Product No such product with id: " + productid);
        }


    }
}
