package ru.sergeysemenov.webshopspring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.sergeysemenov.webshopspring.entities.Cart;
import ru.sergeysemenov.webshopspring.entities.Product;
import ru.sergeysemenov.webshopspring.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;
    private final ProductService productService;


    @GetMapping("/show-cart")
    public List<Product> getProductsInCart(){
        return cart.getProductsList();
    }

    @GetMapping("/add-to-cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addProductIntoCart(@PathVariable Long id){
        cart.getProductsList().add(productService.findProductById(id));
    }
}
