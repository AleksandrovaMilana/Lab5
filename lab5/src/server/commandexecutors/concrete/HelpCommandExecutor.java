package server.commandexecutors.concrete;

import contract.dto.commandexecutionresultdto.concrete.HelpCommandExecutionResultDTO;
import contract.CommandIdentifier;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import server.commandexecutors.CommandExecutor;

import java.util.HashMap;
import java.util.Map;

public class HelpCommandExecutor implements CommandExecutor {
    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        Map<CommandIdentifier, String> helpMap = new HashMap<>();
        helpMap.put(CommandIdentifier.ADD, "add: команда добавления музыкальной группы в коллекцию");
        helpMap.put(CommandIdentifier.REMOVE_BY_ID, "remove_by_id: удалить элемент из коллекции по его id");
        helpMap.put(CommandIdentifier.INFO, "info: вывести в стандартный поток вывода информацию о коллекции");
        helpMap.put(CommandIdentifier.SHOW, "show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        helpMap.put(CommandIdentifier.UPDATE, "update: обновить значение элемента коллекции, id которого равен заданному");
        helpMap.put(CommandIdentifier.CLEAR, "clear: очистить коллекцию");
        helpMap.put(CommandIdentifier.SAVE, "save: сохранить коллекцию в файл");
        helpMap.put(CommandIdentifier.EXECUTE_SCRIPT, "execute_script: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        helpMap.put(CommandIdentifier.EXIT, "exit: завершить программу (без сохранения в файл)");
        helpMap.put(CommandIdentifier.REMOVE_AT, "remove_at: удалить элемент, находящийся в заданной позиции коллекции (index)");
        helpMap.put(CommandIdentifier.ADD_IF_MAX, "add_if_max: добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        helpMap.put(CommandIdentifier.SORT, "sort: отсортировать коллекцию в естественном порядке");
        helpMap.put(CommandIdentifier.REMOVE_ALL_BY_STUDIO, "remove_all_by_studio: удалить из коллекции все элементы, значение поля studio которого эквивалентно заданному");
        helpMap.put(CommandIdentifier.SUM_OF_NUMBER_OF_PARTICIPANTS, "sum_of_number_of_participants: вывести сумму значений поля numberOfParticipants для всех элементов коллекции");
        helpMap.put(CommandIdentifier.COUNT_BY_STUDIO, "count_by_studio: вывести количество элементов, значение поля studio которых равно заданному");
        return new HelpCommandExecutionResultDTO(helpMap);
    }
}
