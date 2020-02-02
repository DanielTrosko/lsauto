package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.ProductDTO;
import it.danieltrosko.lsauto.mapper.ProductMapper;
import it.danieltrosko.lsauto.model.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProductList() {
        return productRepository.findAll().stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }
}
