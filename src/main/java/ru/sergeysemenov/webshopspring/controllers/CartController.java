package ru.sergeysemenov.webshopspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sergeysemenov.webshopspring.entities.Cart;
import ru.sergeysemenov.webshopspring.entities.Product;
import ru.sergeysemenov.webshopspring.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/cart")
public class CartController {
    private Cart cart;
    private ProductService productService;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return cart.getProductsList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addProductInCart(@PathVariable Long id){
        cart.getProductsList().add(productService.findProductById(id));
    }

}
