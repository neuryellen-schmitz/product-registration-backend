package br.com.restaurant.services;

import br.com.restaurant.dtos.ProductDTO;
import br.com.restaurant.entities.ProductEntity;
import br.com.restaurant.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> toDTO(productEntity))
                .collect(Collectors.toList());
    }

    public ProductDTO getById(UUID uuid) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(uuid);
        return productEntityOptional.isPresent() ? toDTO(productEntityOptional.get()) : null;
    }

    public ProductDTO save(ProductDTO productDTO) {
        return toDTO(productRepository.save(toEntity(productDTO)));
    }

    private ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = productEntity.getId();
        productDTO.name = productEntity.getName();
        return productDTO;
    }

    private ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.id);
        productEntity.setName(productDTO.name);
        return productEntity;
    }

}
