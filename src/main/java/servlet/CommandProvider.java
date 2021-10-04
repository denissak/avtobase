package servlet;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
        commands.put(CommandName.LOGIN, new Login());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.REGISTRATION, new Registration());
    }

    public Command takeCommand (String name){
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }

}
