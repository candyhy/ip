package duke.command;

import duke.duke.Duke;
import duke.exceptions.InvalidArgumentException;
import duke.exceptions.InvalidCommandException;

/**
 * Validates user command.
 */
public class ValidateCommand {
    public static int validateDoneCommand(String userInput, Duke bot) throws InvalidArgumentException {
        return DoneCommand.validateArgument(userInput, bot);
    }

    public static int validateDeleteCommand(String userInput, Duke bot) throws InvalidArgumentException {
        return DeleteCommand.validateArgument(userInput, bot);
    }

    public static String[] validateDeadlineCommand(String userInput) throws InvalidArgumentException {
        return DeadlineCommand.validateArgument(userInput);
    }

    public static String[] validateEventCommand(String userInput) throws InvalidArgumentException {
        return EventCommand.validateArgument(userInput);
    }

    /**
     * Validates single argument commands.
     * @param userInput User input as String.
     * @return User input as Command.
     * @throws InvalidCommandException If command in invalid.
     */
    public static Command validateSingleArgumentCommand(String userInput) throws InvalidCommandException {
        Command userCommand;
        switch (userInput) {
        case "todo":
        case "done":
        case "delete":
        case "deadline":
        case "event":
        case "find":
            throw new InvalidCommandException("OOPS!!! " + "The description of "
                    + userInput + " command cannot be empty.\n");
        case "bye":
            userCommand = new ByeCommand();
            break;
        case "list":
            userCommand = new ListCommand();
            break;
        case "help":
            userCommand = new HelpCommand();
            break;
        default:
            throw new InvalidCommandException("OOPS!!! "
                    + "I'm sorry, but I don't know what that means :-()\n"
                    + "\nUse 'help' to show list of commands.");
        }
        return userCommand;
    }
}
