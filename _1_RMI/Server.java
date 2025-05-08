import java.util.*;
import java.net.*;
import java.rmi.Naming;
public class Server  {
    public static void main(String[] args) {
        try {
            
            ServerInterfaceImpl obj = new ServerInterfaceImpl();
            Naming.rebind("server", obj);
            System.out.println("Server is ready...");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error Occured " + e.getMessage());
        }
    }
}
