package com.example.retail.retail_management_system.controller;

import com.example.retail.retail_management_system.dto.ApiResponse;
import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductDTO productDTO) {

        ProductDTO dbProductDto = productService.createProduct(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Product created successfully", dbProductDto));
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProducts() {
        List<ProductDTO> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Products list", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProductById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Product found successfully", productDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id,
                                                @RequestBody ProductDTO productDTO) {
        ProductDTO dbProductDto = productService.updateProduct(id, productDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Updated product successfully", dbProductDto));
    }


}
