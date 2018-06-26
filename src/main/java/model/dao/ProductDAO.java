package model.dao;


import model.entity.Product;
import model.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    void create(Product product);

    List<Product> findAllProducts();

    Product findProductById(int id);

    void deleteProduct(int id);


}

