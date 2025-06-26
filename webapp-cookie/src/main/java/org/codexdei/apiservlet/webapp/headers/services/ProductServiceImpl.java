package org.codexdei.apiservlet.webapp.headers.services;

import org.codexdei.apiservlet.webapp.headers.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService{


    @Override
    public List<Product> listProduct() {

        return Arrays.asList(new Product(1L, "Computer Lenovo", "Computing", 1500),
                             new Product(1L, "Computer Table", "Office", 500),
                             new Product(1L, "mouse Lenovo", "Computing", 70));
    }

    @Override
    public Optional<Product> searchProduct(String name) {

        return listProduct().stream().filter(p -> {

            if (name == null || name.isBlank()) {

                return false;
            }

           return p.getName().equalsIgnoreCase(name);

        }).findFirst();
    }
}
