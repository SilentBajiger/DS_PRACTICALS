import java.rmi.*;;

public class Client {
    public static void main(String[] args) {
        try {
            String serverURL = "rmi://localhost:1099/server";
            ServerInterface ob1 = (ServerInterface)Naming.lookup(serverURL);

            double num = (double)ob1.add(5, 10);
            System.out.println("Answer at Client : "+ num);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error at Client End " + e.getMessage());
        }
    }
}
