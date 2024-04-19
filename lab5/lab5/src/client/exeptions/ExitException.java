package client.exeptions;

public class ExitException extends Exception{
    public ExitException(String out) {
        this.out = out;
    }

    public String getOut() {
        return out;
    }

    private String out;

}
