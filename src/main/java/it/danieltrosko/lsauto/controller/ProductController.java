package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.model.repositories.ProductRepository;
import it.danieltrosko.lsauto.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProduct(Model model) {
        model.addAttribute("productList", productService.getAllProductList());
        return "product/show_all_product";
    }
}
