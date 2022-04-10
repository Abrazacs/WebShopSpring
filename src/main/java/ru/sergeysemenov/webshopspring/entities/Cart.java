package ru.sergeysemenov.webshopspring.entities;


import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Cart {
    private List<Product> productsList;

    @PostConstruct
    public void init(){
      productsList = new ArrayList<>();
  }

}
