package client.util;

import client.CommandPreparerForSendToTheServer;
import client.CommandSenderToTheServer;
import client.OutputStringBuilder;
import client.commandDTOBuilder.*;
import client.commandDTOBuilder.cooncrete.*;
import client.commandExecutionResultHandlers.concrete.*;
import client.io.ConsoleReader;
import client.io.ConsoleWriter;
import client.commandExecutionResultHandlers.*;

import java.util.HashMap;
import java.util.Map;

public class ClientInitializer {

    static public ConsoleReader initializeConsoleReader()
    {
        return new ConsoleReader(System.in);
    }

    static public ConsoleWriter initializeConsoleWriter()
    {
        return new ConsoleWriter(System.out);
    }

    static public Map<String, CommandDTOBuilder> initializeCommandDTOBuilders(ConsoleReader consoleReader, ConsoleWriter consoleWriter)

    {
        Map<String, CommandDTOBuilder> commandDTOBuilders = new HashMap<>();
        commandDTOBuilders.put("help", new HelpCommandDTOBuilder());
        commandDTOBuilders.put("add", new AddCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("info", new InfoCommandDTOBuilder());
        commandDTOBuilders.put("show", new ShowCommandDTOBuilder());
        commandDTOBuilders.put("clear", new ClearCommandDTOBuilder());
        commandDTOBuilders.put("save", new SaveCommandDTOBuilder());
        commandDTOBuilders.put("exit", new ExitCommandDTOBuilder());
        commandDTOBuilders.put("update", new UpdateCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("remove_at", new RemoveAtCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("remove_by_id", new RemoveByIdCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("add_if_max", new AddIfMaxCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("sort", new SortCommandDTOBuilder());
        commandDTOBuilders.put("remove_all_by_studio", new RemoveAllByStudioCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("sum_of_number_of_participants", new SumOfNumberOfParticipantsCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("count_by_studio", new CountByStudioCommandDTOBuilder(consoleReader, consoleWriter));
        commandDTOBuilders.put("execute_script", new ExecuteScriptCommandDTOBuilder(commandDTOBuilders, consoleWriter));

        return commandDTOBuilders;
    }

    static public Map<String, CommandExecutionResultHandler> initializeCommandExecutionResultDTOHandlers()

    {
        Map<String, CommandExecutionResultHandler> commandExecutionResultDTOHandlers = new HashMap<>();
        commandExecutionResultDTOHandlers = new HashMap<>();
        commandExecutionResultDTOHandlers.put("info", new InfoCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("help", new HelpCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("show", new ShowCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("clear", new ClearCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("exit", new ExitCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("sort", new SortCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("save", new SaveCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("add", new AddCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("add_if_max", new AddIfMaxCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("remove_at", new RemoveAtCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("remove_all_by_studio", new RemoveAllByStudioCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("sum_of_number_of_participants", new SumOfNumberOfParticipantsCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("count_by_studio", new CountByStudioCommandExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("execute_script", new ExecuteScriptCommandExecutionResultHandler(commandExecutionResultDTOHandlers));
        commandExecutionResultDTOHandlers.put("remove_by_id", new RemoveByIdExecutionResultHandler());
        commandExecutionResultDTOHandlers.put("update", new UpdateCommandExecutionResultHandler());
        return commandExecutionResultDTOHandlers;
    }

    static public CommandPreparerForSendToTheServer initializeCommandPreparerForSendToTheServer(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        return new CommandPreparerForSendToTheServer(consoleReader, consoleWriter);
    }

    static public CommandSenderToTheServer initializeCommandSenderToTheServer()
    {
        return new CommandSenderToTheServer();
    }

    static public OutputStringBuilder initializeOutputStringBuilder()
    {
        return new OutputStringBuilder();
    }

}