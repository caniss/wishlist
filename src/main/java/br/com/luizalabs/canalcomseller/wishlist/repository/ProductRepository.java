package br.com.luizalabs.canalcomseller.wishlist.repository;

import br.com.luizalabs.canalcomseller.wishlist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
