package by.epam.jwd.sak.avtobase.controller;

import by.epam.jwd.sak.avtobase.controller.impl.AllCar;
import by.epam.jwd.sak.avtobase.controller.impl.AllComment;
import by.epam.jwd.sak.avtobase.controller.impl.AllDriver;
import by.epam.jwd.sak.avtobase.controller.impl.AllRequest;
import by.epam.jwd.sak.avtobase.controller.impl.AllRequestByDriver;
import by.epam.jwd.sak.avtobase.controller.impl.AllUser;
import by.epam.jwd.sak.avtobase.controller.impl.AllUserComment;
import by.epam.jwd.sak.avtobase.controller.impl.AllUserRequest;
import by.epam.jwd.sak.avtobase.controller.impl.CreateCar;
import by.epam.jwd.sak.avtobase.controller.impl.CreateComment;
import by.epam.jwd.sak.avtobase.controller.impl.CreateRequest;
import by.epam.jwd.sak.avtobase.controller.impl.EditCar;
import by.epam.jwd.sak.avtobase.controller.impl.EditRequestByUser;
import by.epam.jwd.sak.avtobase.controller.impl.EditStatusRequestByDriver;
import by.epam.jwd.sak.avtobase.controller.impl.EditUser;
import by.epam.jwd.sak.avtobase.controller.impl.EditUserByAdmin;
import by.epam.jwd.sak.avtobase.controller.impl.Language;
import by.epam.jwd.sak.avtobase.controller.impl.Login;
import by.epam.jwd.sak.avtobase.controller.impl.Logout;
import by.epam.jwd.sak.avtobase.controller.impl.Registration;
import by.epam.jwd.sak.avtobase.controller.impl.SetDriverOnCar;
import by.epam.jwd.sak.avtobase.controller.impl.SetDriverOnRequest;
import by.epam.jwd.sak.avtobase.controller.impl.Test;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {

        commands.put(CommandName.LOGIN, new Login());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.EDITUSER, new EditUser());
        commands.put(CommandName.EDITUSERBYADMIN, new EditUserByAdmin());
        commands.put(CommandName.ALLUSERREQUEST, new AllUserRequest());
        commands.put(CommandName.CREATEREQUEST, new CreateRequest());
        commands.put(CommandName.ALLUSER, new AllUser());
        commands.put(CommandName.EDITREQUESTBYUSER, new EditRequestByUser());
        commands.put(CommandName.CREATECAR, new CreateCar());
        commands.put(CommandName.CREATECOMMENT, new CreateComment());
        commands.put(CommandName.ALLCOMMENT, new AllComment());
        commands.put(CommandName.ALLUSERCOMMENT, new AllUserComment());
        commands.put(CommandName.ALLREQUEST, new AllRequest());
        commands.put(CommandName.SETDRIVERONREQUEST, new SetDriverOnRequest());
        commands.put(CommandName.ALLCAR, new AllCar());
        commands.put(CommandName.SETDRIVERONCAR, new SetDriverOnCar());
        commands.put(CommandName.EDITCAR, new EditCar());
        commands.put(CommandName.ALLDRIVER, new AllDriver());
        commands.put(CommandName.ALLREQUESTBYDRIVER, new AllRequestByDriver());
        commands.put(CommandName.EDITSTATUSREQUESTBYDRIVER, new EditStatusRequestByDriver());
        commands.put(CommandName.TEST, new Test());
        commands.put(CommandName.LANGUAGE, new Language());
    }

    public Command takeCommand(String name) {
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }

}
