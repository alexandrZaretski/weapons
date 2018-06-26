package model.logic;

import model.dao.ProductDAO;
import model.dao.TransactionDAO;
import model.dao.impl.ProductDAOImpl;
import model.dao.impl.TransactionDAOImpl;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;

public class BoughtReceiver {
    public void setOrder(User user, Cart cart) {
        int userId = user.getId();
        TransactionDAO dao = new TransactionDAOImpl();
        for (int i = 0; i < cart.getList().size(); i++) {
            dao.addTransaction(userId, cart.getList().get(i));
        }
    }
}
