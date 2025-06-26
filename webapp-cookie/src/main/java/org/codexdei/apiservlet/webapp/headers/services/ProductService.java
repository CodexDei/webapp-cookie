package org.codexdei.apiservlet.webapp.headers.services;

import org.codexdei.apiservlet.webapp.headers.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listProduct();
    Optional<Product> searchProduct(String name);
}
