package model.command;


import model.logic.AdminReceiver;
import model.logic.BoughtReceiver;
import model.logic.CartReceiver;
import model.logic.UserReceiver;

public enum CommandType {

    LOGIN(new LoginCommand(new UserReceiver())),
    CART(new CartCommand(new CartReceiver())),
    BOUGHT(new BoughtCommand(new BoughtReceiver())),
    ADMIN(new AdminComand(new AdminReceiver(), new UserReceiver())),
    SIGN_UP(new RegistrationCommand(new UserReceiver()));


    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
