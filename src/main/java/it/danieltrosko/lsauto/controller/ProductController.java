package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.model.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/getproduc")
    public String getProductById(Long id, Model model) {
        model.addAttribute("product", productRepository.getOne(id));
        return "/showproduct";
    }
}
