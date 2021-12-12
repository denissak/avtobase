package by.epam.jwd.sak.avtobase.controller;

import by.epam.jwd.sak.avtobase.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton-based class which provides specific realization of {@link Command}
 * by command name.
 *
 * @see CommandName
 * @see Command
 */

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {

        commands.put(CommandName.LOGIN, new Login());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.EDITUSERBYADMIN, new EditUserByAdmin());
        commands.put(CommandName.ALLUSERREQUEST, new AllUserRequest());
        commands.put(CommandName.CREATEREQUEST, new CreateRequest());
        commands.put(CommandName.ALLUSER, new AllUser());
        commands.put(CommandName.ALLDISABLEDUSER, new AllDisabledUser());
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
        commands.put(CommandName.LANGUAGE, new Language());
        commands.put(CommandName.EDITSTATUSCAR, new EditStatusCar());
        commands.put(CommandName.WELCOMEPAGE, new WelcomePage());
        commands.put(CommandName.ERRORPAGE, new ErrorPage());
    }

    public Command takeCommand(String name) {
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }

}
