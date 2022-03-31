package com.vnaazleen.instrumentDelight.controller;

import com.vnaazleen.instrumentDelight.model.ProductModel;
import com.vnaazleen.instrumentDelight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ProductModel productSave(@RequestBody ProductModel product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<ProductModel> getProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ProductModel productEditData(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public String productDelete(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ProductModel productEditSave(@RequestBody ProductModel data) {
        return productService.editProduct(data);
    }

}
