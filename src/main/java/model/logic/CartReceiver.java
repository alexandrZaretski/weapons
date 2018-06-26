package model.logic;

import model.dao.impl.ProductDAOImpl;
import model.dao.impl.UserDAOImpl;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartReceiver {

    public Cart getCart(List<Integer> listId) {
        Cart cart = null;
        List<Product> productList = new ArrayList<Product>();
        Iterator<Integer> it = listId.iterator();
        ProductDAOImpl dao = new ProductDAOImpl();
        while (it.hasNext()) {
            productList.add(dao.findProductById(it.next()));
        }

        cart = new Cart(productList);

        return cart;

    }
}
