package com.example.productsandcategories.repositories;

import com.example.productsandcategories.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends CrudRepository<Product, Long> {

    @Query(value = "select * from products as p where p.id not in (select cp.product_id from categories_products as cp where cp.category_id = ?1 )",
            nativeQuery = true)
    List<Product> getAllnotIn(Long id);


}
