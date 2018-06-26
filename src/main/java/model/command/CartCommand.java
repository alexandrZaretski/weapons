package model.command;

import model.entity.Cart;
import model.logic.CartReceiver;
import model.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartCommand implements Command {
    CartReceiver cartReceiver;

    private static final String PATH_PAGE_CLIENT = "/jsp/client.jsp";
    private static final String PATH_PAGE_CART = "/jsp/cart.jsp";

    public CartCommand(CartReceiver cartReceiver) {
        this.cartReceiver = cartReceiver;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String strId[] = request.getParameterValues("idProduct");
        System.out.println(Arrays.toString(strId));
        if (strId == null) {
            request.setAttribute("errorNotPuy", MessageManager.getMessage("messages.cart.not.puy"));
            return PATH_PAGE_CLIENT;
        }
        stringToInt(strId);

        Cart cart = cartReceiver.getCart(stringToInt(strId));

        request.getSession(true).setAttribute("cart", cart);

        return PATH_PAGE_CART;
    }

    private List<Integer> stringToInt(String strId[]) {
        List<Integer> intId = new ArrayList<Integer>();

        for (int i = 0; i < strId.length; i++) {
            intId.add(Integer.valueOf(strId[i]));
        }
        return intId;
    }

}
