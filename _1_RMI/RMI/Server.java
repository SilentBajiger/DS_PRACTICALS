import java.rmi.*;

public class Server{
    public static void main(String[] args) {
        try {
            
            RMI_Interface_Impl obj = (RMI_Interface_Impl) new RMI_Interface_Impl();
            // Naming.bind("MainServer", obj);
            Naming.bind("rmi://localhost:1099/MainServer", obj);
            // Naming.rebind("rmi://localhost:1099/MainServer", obj); // if it is throws already bound Exception
            // means object is already registered in rmiregistry

            System.out.println("Server is Listening on Localhost...");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error at Server end " + e.getMessage());
            e.printStackTrace();
        }
    }
}
