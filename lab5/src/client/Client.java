package client;

import client.exeptions.ExitException;
import client.exeptions.UnknownCommandException;
import client.io.ConsoleReader;
import client.io.ConsoleWriter;
import client.util.ClientInitializer;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

import java.util.Arrays;

public class Client
{

    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;
    private final CommandPreparerForSendToTheServer commandPreparerForSendToTheServer;
    private final CommandSenderToTheServer commandSenderToTheServer;
    private final OutputStringBuilder outputStringBuilder;

    public Client()
    {
        this.consoleReader = ClientInitializer.initializeConsoleReader();
        this.consoleWriter = ClientInitializer.initializeConsoleWriter();
        this.commandPreparerForSendToTheServer = ClientInitializer.initializeCommandPreparerForSendToTheServer(consoleReader, consoleWriter);
        this.commandSenderToTheServer = ClientInitializer.initializeCommandSenderToTheServer();
        this.outputStringBuilder = ClientInitializer.initializeOutputStringBuilder();
    }

    public void start()
    {
        while (true)
        {
            try {

            this.consoleWriter.printlnToOutputStream("Введите команду:");

            String[] tokens = this.consoleReader.getNextLine().split(" ");
            String commandName = tokens[0];
            String[] commandArguments = Arrays.copyOfRange(tokens, 1, tokens.length);

            CommandDTO commandDTO = this.commandPreparerForSendToTheServer
                        .prepareCommandDTOForSending(commandName, commandArguments);

            CommandExecutionResultDTO commandExecutionResultDTO = this.commandSenderToTheServer
                    .sendCommandDTOToTheServer(commandDTO);

            this.consoleWriter.printlnToOutputStream(
                    this.outputStringBuilder.buildOutputString(commandExecutionResultDTO)
            );

            } catch (UnknownCommandException unknownCommandException)
            {
                consoleWriter.printlnToOutputStream("Неизвестная команда");
            }
            catch (ExitException exception)
            {
                consoleWriter.printlnToOutputStream(exception.getOut());
                consoleWriter.printlnToOutputStream("Выход из программы из-за команды exit");
                System.exit(0);
            }
        }

    }






}
