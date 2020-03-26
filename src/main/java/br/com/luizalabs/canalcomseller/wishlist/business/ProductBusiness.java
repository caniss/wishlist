package br.com.luizalabs.canalcomseller.wishlist.business;

import br.com.luizalabs.canalcomseller.wishlist.model.Product;

import java.util.UUID;

public interface ProductBusiness {

    public Product findByUuid(UUID uuid);
    public Product addProdutc(Product product);
    public Product removeProduct(UUID uuid);
}
