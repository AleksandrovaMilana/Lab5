package contract;

public enum CommandIdentifier
{
    ADD("add"),
    REMOVE_BY_ID("remove_by_id"),
    INFO("info"),
    SHOW("show"),
    UPDATE("update"),
    CLEAR("clear"),
    SAVE("save"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    REMOVE_AT("remove_at"),
    ADD_IF_MAX("add_if_max"),
    SORT("sort"),
    REMOVE_ALL_BY_STUDIO("remove_all_by_studio"),
    SUM_OF_NUMBER_OF_PARTICIPANTS("sum_of_number_of_participants"),
    COUNT_BY_STUDIO("count_by_studio");

    private final String commandName;

    CommandIdentifier(String commandName)
    {
        this.commandName = commandName;
    }

    public String getCommandName()
    {
        return commandName;
    }
}
