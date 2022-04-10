package ru.sergeysemenov.webshopspring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sergeysemenov.webshopspring.dtos.CreateNewProductDto;
import ru.sergeysemenov.webshopspring.entities.Cart;
import ru.sergeysemenov.webshopspring.entities.Product;
import ru.sergeysemenov.webshopspring.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;
    private Cart cart;


    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducts(@RequestBody CreateNewProductDto createNewProductDto) {
        productService.createNewProduct(createNewProductDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/cart")
    public List<Product> getProductsInCart(){
        return cart.getProductsList();
    }

    @GetMapping("/cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addProductIntoCart(@PathVariable Long id){
        cart.getProductsList().add(productService.findProductById(id));
    }


}
