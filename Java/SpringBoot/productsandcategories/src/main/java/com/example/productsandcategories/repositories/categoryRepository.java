package com.example.productsandcategories.repositories;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "select * from categories as c where c.id not in (select cp.category_id from categories_products as cp where cp.product_id = ?1 )",
            nativeQuery = true)
    List<Category> getAllnotIn(Long id);


}
