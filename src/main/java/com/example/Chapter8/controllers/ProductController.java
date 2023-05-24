package com.example.Chapter8.controllers;

import com.example.Chapter8.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Chapter8.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    //@RequestMapping("/products")
    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);

        return "products.html";
    }

    //@RequestMapping(path="/products",method = RequestMethod.POST)
    @PostMapping("/products2")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        List<Product> products = productService.findAll();
        model.addAttribute("products",products);

        return "products.html";
    }
    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);

        return "products.html";
    }
}

