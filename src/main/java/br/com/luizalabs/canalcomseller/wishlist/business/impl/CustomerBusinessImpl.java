package br.com.luizalabs.canalcomseller.wishlist.business.impl;

import br.com.luizalabs.canalcomseller.wishlist.business.CustomerBusiness;
import br.com.luizalabs.canalcomseller.wishlist.model.Customer;
import br.com.luizalabs.canalcomseller.wishlist.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBusinessImpl implements CustomerBusiness {
    private static CustomerRepository  customerRepository;

    @Autowired
    public CustomerBusinessImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}


