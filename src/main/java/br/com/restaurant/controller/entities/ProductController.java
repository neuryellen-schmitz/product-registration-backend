package br.com.restaurant.controller.entities;

import br.com.restaurant.dtos.ProductDTO;
import br.com.restaurant.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entities/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> list() {
        return getResponse(productService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> find(@PathVariable("id") UUID id) {
        return getResponse(productService.getById(id));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return getResponse(productService.save(productDTO));
    }

    private ResponseEntity<List<ProductDTO>> getResponse(List<ProductDTO> products) {
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    private ResponseEntity<ProductDTO> getResponse(ProductDTO product) {
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
