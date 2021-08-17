package br.com.restaurant.controller.entities;

import br.com.restaurant.dtos.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entities/product")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<ProductDTO>> list() {
        List<ProductDTO> products = Arrays.asList(new ProductDTO(UUID.randomUUID(), "test"));
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> find(@PathVariable("id") Long id) {
        ProductDTO product = new ProductDTO(UUID.randomUUID(), "test");
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
