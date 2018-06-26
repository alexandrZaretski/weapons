package model.command;


import model.dao.ProductDAO;
import model.dao.impl.ProductDAOImpl;
import model.entity.User;
import model.logic.UserReceiver;
import model.manager.MessageManager;
import model.validator.SignUpValdator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PATH_PAGE_LOGIN = "/login.jsp";
    private static final String PATH_PAGE_ADMIN = "/jsp/admin.jsp";
    private static final String PATH_PAGE_CLIENT = "/jsp/client.jsp";

    private UserReceiver receiver;

    public LoginCommand(UserReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PATH_PAGE_LOGIN;
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);


        if (SignUpValdator.isUserPasswordCorrect(passValue) && SignUpValdator.isUserEmailCorrect(loginValue)) {
            if (request.getSession(true).getAttribute("user") != null) {
                request.setAttribute("userInSystem", MessageManager.getMessage("messages.login.error.in.system"));
                return PATH_PAGE_LOGIN;
            }
            try {

                User user = receiver.checkUser(loginValue, passValue);

                if (user != null) {
                    request.getSession(true).setAttribute("userName", user.getName());

                    page = getPathPage(user, request);
                    request.getSession(true).setAttribute("user", user);


                } else {
                    request.setAttribute("errorLoginPassMessage", MessageManager.getMessage("messages.login.error"));
                    page = PATH_PAGE_LOGIN;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getMessage("messages.login.empty"));

        }
        return page;
    }

    private String getPathPage(User user, HttpServletRequest request) {
        request.getSession(true).setAttribute("Logout", MessageManager.getMessage("messages.Logout"));
        if (user.getId_role() == 2) {

            request.getSession(true).setAttribute("cartJsp", PATH_PAGE_CLIENT);
            request.getSession(true).setAttribute("messagesCart", MessageManager.getMessage("messages.cart"));
            ProductDAOImpl dao = new ProductDAOImpl();

            request.getSession(true).setAttribute("Products", dao.findAllProducts());
            return PATH_PAGE_CLIENT;
        }
        request.getSession(true).setAttribute("cartJsp", PATH_PAGE_ADMIN);
        request.getSession(true).setAttribute("messagesCart", MessageManager.getMessage("messages.admin"));
        return PATH_PAGE_ADMIN;

    }

}