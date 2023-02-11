import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            ServerInterface server = (ServerInterface) Naming.lookup("rmi://localhost:1099/Server");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(server.getFile(input));
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
