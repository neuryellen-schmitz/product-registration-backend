package br.com.restaurant.services;

import br.com.restaurant.dtos.ProductDTO;
import br.com.restaurant.entities.ProductEntity;
import br.com.restaurant.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    private List<ProductEntity> productEntityList;
    private ProductDTO productDTO;

    @Before
    public void init() {
        initMocks(this);

        productDTO = new ProductDTO();
        productDTO.id = UUID.randomUUID();
        productDTO.name = "test";
        productEntityList = Arrays.asList(new ProductEntity(productDTO.id, productDTO.name));

        when(productRepository.findAll()).thenReturn(productEntityList);
    }

    @Test
    public void shouldReturnAll() {
        List<ProductDTO> result = productService.getAll();
        assertEquals(1, result.size());
        assertEquals(productDTO.id, result.get(0).id);
    }
}
