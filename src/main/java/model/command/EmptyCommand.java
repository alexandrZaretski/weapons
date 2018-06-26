package model.command;


import model.logic.DefaultReceiver;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    private DefaultReceiver receiver = new DefaultReceiver();

    @Override
    public String execute(HttpServletRequest request) {

        return receiver.getPath();
    }
}