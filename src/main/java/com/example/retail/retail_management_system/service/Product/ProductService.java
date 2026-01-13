package com.example.retail.retail_management_system.service.Product;

import com.example.retail.retail_management_system.dto.ProductDTO;
import com.example.retail.retail_management_system.exception.NotFoundException;
import com.example.retail.retail_management_system.mapper.ProductMapper;
import com.example.retail.retail_management_system.model.Product;
import com.example.retail.retail_management_system.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        Product product = productMapper.toEntity(productDTO);

        return productMapper.toDTO(productRepo.save(product));
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepo.findAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {

        Product product =  productRepo.findById(id).orElseThrow( () -> new NotFoundException("Product not found"));

        return productMapper.toDTO(product);
    }

    @Override
    public void deleteProduct(Long id) {

        if (!productRepo.existsById(id)) {
            throw new NotFoundException("Product not found");
        }

        productRepo.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepo.findById(id).orElseThrow( () -> new NotFoundException("Product not found"));

        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }
        if (productDTO.getBrand() != null) {
            product.setName(productDTO.getBrand());
        }
        if (productDTO.getCurrentPrice() != null) {
            product.setCurrentPrince(productDTO.getCurrentPrice());
        }
        if (productDTO.getStock() != product.getStock()) {
            product.setStock(productDTO.getStock());
        }

        return productMapper.toDTO(productRepo.save(product));
    }
}
