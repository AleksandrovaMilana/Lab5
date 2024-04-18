package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.exeptions.RecursiveScriptExecutionException;
import client.exeptions.UnknownCommandException;
import client.io.ConsoleWriter;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.ExecuteScriptCommandDTO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExecuteScriptCommandDTOBuilder implements CommandDTOBuilder
{
    private final Map<String, CommandDTOBuilder> commandDTOBuilders;
    private Set<String> scripts;
    private ConsoleWriter consoleWriter;

    public ExecuteScriptCommandDTOBuilder(Map<String, CommandDTOBuilder> commandDTOBuilders, ConsoleWriter consoleWriter) {
        this.commandDTOBuilders = commandDTOBuilders;
        scripts = new HashSet<>();
        this.consoleWriter = consoleWriter;
    }

    @Override
    public CommandDTO buildCommandDTO(String[] commandArguments) {
        scripts.add(commandArguments[0].trim());
        Scanner fileScanner;
        BufferedInputStream fileInputStream;
        String[] fileStrings;
        try {
            fileInputStream = new BufferedInputStream(
                    new FileInputStream(System.getProperty("user.dir") + File.separator + commandArguments[0]));
            String file = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
            fileStrings = file.split("\\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<CommandDTO> commandDTOList = new ArrayList<>();

        try {

            for (StringIterator stringIterator = new StringIterator();
                 stringIterator.getI() < fileStrings.length; stringIterator.increment()) {

                String[] tokens = fileStrings[stringIterator.getI()].split(" ");
                String commandName = tokens[0];
                String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);

                if (arguments.length == 0)
                {
                    arguments = new String[1];
                    arguments[0] = "ftd";
                }

                try {
                    if (this.commandDTOBuilders.get(commandName.trim()) == null)
                    {
                        throw new UnknownCommandException();
                    }
                    commandDTOList.add(this.commandDTOBuilders.get(commandName.trim()).buildCommandDTOFromScript(fileStrings, stringIterator, arguments[0]));
                } catch (RecursiveScriptExecutionException e){
                    consoleWriter.printlnToOutputStream("Рекурсивное исполнение скрипта. Выполнение всех скриптов отменено");
                    scripts.clear();
                    return new ExecuteScriptCommandDTO(new ArrayList<>());
                }

            }

        } catch (InvalidCommandArgumentsInScriptFileException invalidCommandArgumentsInScriptFileException) {
            consoleWriter.printlnToOutputStream("В скрипте найден неизвестный аргумент для команды либо ошибка. Все команды из файла "
                    + commandArguments[0].trim() + " не будут выполнены");
            scripts.remove(commandArguments[0].trim());
            return new ExecuteScriptCommandDTO(new ArrayList<>());
        } catch (UnknownCommandException e) {
            consoleWriter.printlnToOutputStream("В скрипте найдена неизвестная команда либо ошибка. Все команды из файла "
                    + commandArguments[0].trim() + " не будут выполнены");
            scripts.remove(commandArguments[0].trim());
            return new ExecuteScriptCommandDTO(new ArrayList<>());
        }
        scripts.remove(commandArguments[0].trim());
        return new ExecuteScriptCommandDTO(commandDTOList);
    }


    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws RecursiveScriptExecutionException {
        int size = scripts.size();
        scripts.add(commandArgument.trim());
        int newSize = scripts.size();
        if (size == newSize){
            throw new RecursiveScriptExecutionException();
        }
        Scanner fileScanner;
        BufferedInputStream fileInputStream;
        try {
            fileInputStream = new BufferedInputStream(
                    new FileInputStream(System.getProperty("user.dir") + File.separator + commandArgument.trim()));
            String file = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
            fileStrings = file.split("\\n");
        } catch (FileNotFoundException e) {
            consoleWriter.printlnToOutputStream("Не найден файл скриптов. Выполнение команд из скрипта " +
                    commandArgument.trim() + " отменено");
            scripts.remove(commandArgument.trim());
            return new ExecuteScriptCommandDTO(new ArrayList<>());
        } catch (IOException e) {
            consoleWriter.printlnToOutputStream("Ошибка ввода вывода. Выполнение команд из скрипта отменено");
            scripts.remove(commandArgument.trim());
            return new ExecuteScriptCommandDTO(new ArrayList<>());
        }


        List<CommandDTO> commandDTOList = new ArrayList<>();

        try {

            for ( StringIterator stringIterator1 = new StringIterator();
                  stringIterator1.getI() < fileStrings.length ; stringIterator1.increment()) {


                String[] tokens = fileStrings[stringIterator1.getI()].split(" ");
                String commandName = tokens[0];
                String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);

                if (arguments.length == 0)
                {
                    arguments = new String[1];
                    arguments[0] = "mint";
                }
                if (this.commandDTOBuilders.get(commandName.trim()) == null)
                {
                    throw new UnknownCommandException();
                }

                commandDTOList.add(this.commandDTOBuilders.get(commandName.trim()).buildCommandDTOFromScript(fileStrings, stringIterator1, arguments[0]));

            }
        }catch (InvalidCommandArgumentsInScriptFileException invalidCommandArgumentsInScriptFileException)
        {
            consoleWriter.printlnToOutputStream("В скрипте найден неизвестный аргумент для команды либо ошибка. Все команды из файла "
                    + commandArgument.trim() + " не будут выполнены");
            scripts.remove(commandArgument.trim());
            return new ExecuteScriptCommandDTO(new ArrayList<>());
        } catch (UnknownCommandException e) {
            consoleWriter.printlnToOutputStream("В скрипте найдена неизвестная команда либо ошибка. Все команды из файла "
            + commandArgument.trim() + " не будут выполнены");
            scripts.remove(commandArgument.trim());
            return new ExecuteScriptCommandDTO(new ArrayList<>());
        }
        scripts.remove(commandArgument.trim());
        return new ExecuteScriptCommandDTO(commandDTOList);
    }
}
