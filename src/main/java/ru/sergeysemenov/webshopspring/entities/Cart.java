package ru.sergeysemenov.webshopspring.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class Cart {
    private List<Product> productsList;

    public Cart(){
        productsList = new ArrayList<>();
    }

}
