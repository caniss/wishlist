package br.com.luizalabs.canalcomseller.wishlist.repository;

import br.com.luizalabs.canalcomseller.wishlist.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
