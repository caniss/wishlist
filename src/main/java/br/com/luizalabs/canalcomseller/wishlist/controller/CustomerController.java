package br.com.luizalabs.canalcomseller.wishlist.controller;

import br.com.luizalabs.canalcomseller.wishlist.business.CustomerBusiness;
import br.com.luizalabs.canalcomseller.wishlist.model.Customer;
import br.com.luizalabs.canalcomseller.wishlist.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/customers")
public class CustomerController {

    private static CustomerBusiness customerBusiness;

    @Autowired
    public CustomerController(CustomerBusiness customerBusiness) {
        this.customerBusiness = customerBusiness;
    }

    @GetMapping
    public ResponseEntity<?> listAllCustomers() {
        return new ResponseEntity<>(customerBusiness.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerBusiness.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerBusiness.create(customer), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerBusiness.update(customer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerBusiness.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id, @RequestBody List<Product> products) {
        Customer customer = customerBusiness.findById(id);
        customer.setWhishlist(products);
        return new ResponseEntity<>(customerBusiness.update(customer), HttpStatus.OK);
    }

}
