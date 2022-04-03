package ru.sergeysemenov.webshopspring.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateNewProductDto {
    private String title;
    private int price;
}
