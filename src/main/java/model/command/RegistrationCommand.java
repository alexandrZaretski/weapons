package model.command;


import model.dao.impl.UserDAOImpl;
import model.entity.User;
import model.logic.UserReceiver;
import model.manager.MessageManager;
import model.validator.RegisterValidator;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    /* private final static Logger LOGGER = LogManager.getLogger("RegistrationCommand");





     private ClientReceiver clientReceiver = new ClientReceiver();
     private TrainerReceiver trainerReceiver = new TrainerReceiver();

 */
    private static final String PARAM_NAME = "first_name";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_ADRESS = "adress";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PASSWORD = "password";

    private static final String PATH_PAGE_LOGIN = "/login.jsp";
    private static final String PATH_PAGE_REGISTER = "/register.jsp";
    private UserReceiver receiver;

    public RegistrationCommand(UserReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String name = request.getParameter(PARAM_NAME);
        String phone = request.getParameter(PARAM_PHONE);
        String adress = request.getParameter(PARAM_ADRESS);
        String email = request.getParameter(PARAM_EMAIL);
        String pass = request.getParameter(PARAM_PASSWORD);


        if (RegisterValidator.checkRegistration(name, phone, adress, email, pass)) {

            if (null != new UserDAOImpl().findUserByEmail(email)) {
                request.setAttribute("errorLoginPassMessage", MessageManager.getMessage("messages.login.error"));
                page = PATH_PAGE_REGISTER;

            } else {
                receiver.addUser(name, phone, adress, email, pass);
                page = PATH_PAGE_LOGIN;

            }
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getMessage("messages.login.error"));
            page = PATH_PAGE_REGISTER;
        }


        return page;

    }
}