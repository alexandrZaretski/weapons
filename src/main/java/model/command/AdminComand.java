package model.command;

import model.logic.AdminReceiver;
import model.logic.UserReceiver;
import model.manager.MessageManager;
import utils.WorkDate;

import javax.servlet.http.HttpServletRequest;

public class AdminComand implements Command {
    private AdminReceiver adminReceiver;
    private UserReceiver userReceiver;
    private static final String PATH_PAGE_ADMIN = "/jsp/admin.jsp";

    public AdminComand(AdminReceiver adminReceiver, UserReceiver userReceiver) {
        this.adminReceiver = adminReceiver;
        this.userReceiver = userReceiver;
    }

    @Override
    public String execute(HttpServletRequest request) {

        return whatDo(request.getParameter("show"), request);
    }

    private String whatDo(String comand, HttpServletRequest request) {


        try {
            switch (comand) {
                case "ShowAllUsers":
                    request.setAttribute("table", userReceiver.findAllUsers());
                    break;
                case "deletUserById":
                    int id = Integer.valueOf(request.getParameter("idUser"));
                    userReceiver.deleteUser(id);
                    break;
                case "ShowTransactonByDates":
                    String start = request.getParameter("DateStart");
                    String finish = request.getParameter("DateFinish");
                    request.setAttribute("table", adminReceiver.getTransactionsByDate(WorkDate.stringToDate(start), WorkDate.stringToDate(finish)));
                    break;
                case "ShowTransactonByUserId":
                    int id2 = Integer.valueOf(request.getParameter("UserId"));
                    System.out.println("UserIdddddddddddddddddddddddddddd   " + id2);
                    request.setAttribute("table", adminReceiver.getTransactionsByUser(id2));
                    break;
            }
        } catch (Exception exeption) {

            request.setAttribute("errorAdminDate", MessageManager.getMessage("error.admin.date"));
        }
        return PATH_PAGE_ADMIN;


    }
}
