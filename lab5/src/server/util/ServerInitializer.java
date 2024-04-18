package server.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import server.CollectionManager;
import server.business.MusicBand;
import server.commandexecutors.CommandExecutor;
import server.commandexecutors.concrete.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerInitializer {
    public static CollectionManager initializerCollectionManager() throws IOException {

        //String initFileName = System.getenv("file_name");
        String initFileName = System.getProperty("user.dir") + File.separator + "collection.json";

        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(initFileName)
        );
        String json = new String(bufferedInputStream.readAllBytes(), StandardCharsets.UTF_8);

        if (json.length() < 10){
            return new CollectionManager(new LinkedList<>(), LocalDate.now(), initFileName);
        }

        String initDate = json.substring(json.indexOf(": ")+3, json.indexOf(",") - 1);

        String jsonCollection = json.substring(json.indexOf("[ ") ) ;
        String  jsonColection2 = jsonCollection.substring(0, jsonCollection.lastIndexOf("}") - 1);
        jsonColection2 = jsonColection2.trim();

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        Type listType = new TypeToken<LinkedList<MusicBand>>(){}.getType();
        LinkedList<MusicBand> labWorks = gson.fromJson(jsonColection2, listType);

        return new CollectionManager(labWorks, LocalDate.parse(initDate),initFileName);
    }

    public static Map<String, CommandExecutor> initializerCommandExecutors(CollectionManager collectionManager)
    {

        Map<String, CommandExecutor> commandExecutors = new HashMap<>();
        commandExecutors.put("add", new AddCommandExecutor(collectionManager));
        commandExecutors.put("info", new InfoCommandExecutor(collectionManager));
        commandExecutors.put("help", new HelpCommandExecutor());
        commandExecutors.put("exit", new ExitCommandExecutor());
        commandExecutors.put("show", new ShowCommandExecutor(collectionManager));
        commandExecutors.put("remove_at", new RemoveAtCommandExecutor(collectionManager));
        commandExecutors.put("add_if_max", new AddIfMaxCommandExecutor(collectionManager));
        commandExecutors.put("sort", new SortCommandExecutor(collectionManager));
        commandExecutors.put("remove_all_by_studio", new RemoveAllByStudioCommandExecutor(collectionManager));
        commandExecutors.put("sum_of_number_of_participants", new SumOfNumberOfParticipantsCommandExecutor(collectionManager));
        commandExecutors.put("count_by_studio", new CountByStudioCommandExecutor(collectionManager));
        commandExecutors.put("save", new SaveCommandExecutor(collectionManager));
        commandExecutors.put("clear", new ClearCommandExecutor(collectionManager));
        commandExecutors.put("update", new UpdateCommandExecutor(collectionManager));
        commandExecutors.put("remove_by_id", new RemoveByIdCommandExecutor(collectionManager));
        commandExecutors.put("execute_script", new ExecuteScriptCommandExecutor(commandExecutors));

        commandExecutors.put("help", new HelpCommandExecutor());

        return commandExecutors;
    }
}
