package ru.sergeysemenov.webshopspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.webshopspring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Long id);

}
