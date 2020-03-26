package br.com.luizalabs.canalcomseller.wishlist.business;

import br.com.luizalabs.canalcomseller.wishlist.model.Customer;

import java.util.List;


public interface CustomerBusiness {
    public List<Customer> findAll();
    public Customer findById(Long id);
    public Customer create(Customer customer);
    public Customer update(Customer customer);
    public void delete(Long id);
}
