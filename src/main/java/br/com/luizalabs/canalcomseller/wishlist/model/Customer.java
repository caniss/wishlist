package br.com.luizalabs.canalcomseller.wishlist.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome não pode ser vazio.")
    private String name;

    @NotEmpty(message = "O e-mail não pode ser vazio.")
    @Email(message = "Informe um e-mail válido")
    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "customer_product", joinColumns =
            {@JoinColumn(name = "customer_id")}, inverseJoinColumns =
            {@JoinColumn(name = "product_id")})
    private List<Product> whishlist = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getWhishlist() {
        return whishlist;
    }

    public void setWhishlist(List<Product> whishlist) {
        this.whishlist = whishlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
