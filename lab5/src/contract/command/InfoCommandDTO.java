package contract.command;

public class InfoCommandDTO implements CommandDTO {
    @Override
    public String getCommandName() {
        return "info";
    }
}
