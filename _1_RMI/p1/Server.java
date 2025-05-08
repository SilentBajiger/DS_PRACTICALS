import java.rmi.*;
import java.rmi.server.*;

public class Server {
    public static void main(String[] args) {
        try {
            RMI_Interface obj =(RMI_Interface) new RMI_Interface_Impl();
            Naming.bind("rmi://localhost:1099/server", obj);
            System.out.println("Server is Listening on 1099");
        } catch (Exception e) {
            System.out.println("Error on Server" + e.getMessage());
            e.printStackTrace();
        }
    }
}
