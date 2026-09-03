package com.example.trabajo_evaluativo.Repository;

import com.example.trabajo_evaluativo.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByCategory(String category);

    List<ProductModel> findByNameContainingIgnoreCase(String name);
}