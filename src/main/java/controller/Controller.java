package controller;


import model.command.ActionFactory;
import model.command.Command;
import model.command.EmptyCommand;
import model.manager.MessageManager;
import model.pool.ConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;


@WebServlet("/controller")
public class Controller extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        processRequest(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Optional<Command> commandOptional = ActionFactory.defineCommand(request.getParameter("command"));


            Command command = commandOptional.orElse(new EmptyCommand());

            String page = command.execute(request);

            if (page != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                dispatcher.forward(request, response);
            } else {
                request.getSession().setAttribute("nullPage", MessageManager.getMessage("messages.nullpage"));
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }


    }


    @Override
    public void destroy() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        for (int i = 0; i < connectionPool.poolSize(); i++) {
            try {
                connectionPool.closeConnection(connectionPool.getConnection());
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }
}

