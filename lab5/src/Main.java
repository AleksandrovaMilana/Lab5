import client.InputHandler;
import client.MainClientProgram;
import server.Server;

public class Main {

    public static void main(String[] args)
    {

        MainClientProgram mainClientProgram = new MainClientProgram(
                        System.out,
                        System.in
        );

        mainClientProgram.start();

    }

}