package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.ProductDTO;
import it.danieltrosko.lsauto.model.entites.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPartNumber(product.getPartNumber());
        productDTO.setAmount(product.getAmount());
        productDTO.setLocation(product.getLocation());
        productDTO.setBrand(product.getBrand());
        productDTO.setOemNumber(product.getOemNumber());
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPartNumber(productDTO.getPartNumber());
        product.setAmount(productDTO.getAmount());
        product.setLocation(productDTO.getLocation());
        product.setBrand(productDTO.getBrand());
        product.setOemNumber(productDTO.getOemNumber());
        return product;
    }
}
