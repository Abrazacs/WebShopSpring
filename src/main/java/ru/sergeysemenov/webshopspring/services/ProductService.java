package ru.sergeysemenov.webshopspring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.webshopspring.dtos.CreateNewProductDto;
import ru.sergeysemenov.webshopspring.entities.Product;
import ru.sergeysemenov.webshopspring.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(CreateNewProductDto createNewProductDto) {
        Product product = new Product();
        product.setTitle(createNewProductDto.getTitle());
        product.setPrice(createNewProductDto.getPrice());
        productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findProductById(id);
    }
}
