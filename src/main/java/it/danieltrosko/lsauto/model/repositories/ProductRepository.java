package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
