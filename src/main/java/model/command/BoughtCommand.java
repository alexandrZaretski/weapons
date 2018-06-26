package model.command;

import model.entity.Cart;
import model.entity.User;
import model.logic.BoughtReceiver;

import javax.servlet.http.HttpServletRequest;

public class BoughtCommand implements Command {
    private static final String PATH_PAGE_BUY_IN_CART = "/jsp/bought.jsp";
    public BoughtReceiver bR;

    public BoughtCommand(BoughtReceiver bR) {
        this.bR = bR;
    }

    @Override
    public String execute(HttpServletRequest request) {
        bR.setOrder((User) request.getSession(true).getAttribute("user"),
                (Cart) request.getSession(true).getAttribute("cart"));

        return PATH_PAGE_BUY_IN_CART;
    }
}
