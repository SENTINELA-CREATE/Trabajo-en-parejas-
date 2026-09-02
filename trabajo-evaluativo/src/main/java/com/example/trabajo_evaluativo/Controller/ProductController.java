package com.example.trabajo_evaluativo.Controller;

import com.example.trabajo_evaluativo.Service.ProductService;
import com.example.trabajo_evaluativo.dto.ProductInputDTO;
import com.example.trabajo_evaluativo.dto.ProductOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductOutputDTO> createProduct(@RequestBody ProductInputDTO dto) {
        ProductOutputDTO createdProduct = productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductOutputDTO>> getAllProducts() {
        List<ProductOutputDTO> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutputDTO> getProductById(@PathVariable Long id) {
        ProductOutputDTO product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOutputDTO> updateProduct(@PathVariable Long id, @RequestBody ProductInputDTO dto) {
        ProductOutputDTO updatedProduct = productService.updateProduct(id, dto);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Product eliminado correctamente");
    }

