package com.example.trabajo_evaluativo.Service;

import com.example.trabajo_evaluativo.Model.ProductModel;
import com.example.trabajo_evaluativo.Repository.ProductRepository;
import com.example.trabajo_evaluativo.dto.ProductInputDTO;
import com.example.trabajo_evaluativo.dto.ProductOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductOutputDTO createProduct(ProductInputDTO dto) {
        ProductModel product = ProductModel.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .category(dto.getCategory())
                .creationDate(LocalDateTime.now())
                .build();

        ProductModel savedProduct = productRepository.save(product);
        return mapToOutputDTO(savedProduct);
    }

    public List<ProductOutputDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToOutputDTO)
                .collect(Collectors.toList());
    }

    public ProductOutputDTO findById(Long id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        return mapToOutputDTO(product);
    }

    public ProductOutputDTO updateProduct(Long id, ProductInputDTO dto) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCategory(dto.getCategory());

        ProductModel updatedProduct = productRepository.save(product);
        return mapToOutputDTO(updatedProduct);
    }

    public void deleteById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    private ProductOutputDTO mapToOutputDTO(ProductModel product) {
        return ProductOutputDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(product.getCategory())
                .creationDate(product.getCreationDate())
                .build();
    }

    public List<ProductOutputDTO> findByCategory(String category) {
        return productRepository.findByCategory(category).stream()
                .map(this::mapToOutputDTO)
                .collect(Collectors.toList());
    }

    public List<ProductOutputDTO> findByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::mapToOutputDTO)
                .collect(Collectors.toList());
    }
}