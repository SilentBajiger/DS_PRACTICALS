import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            
            RMI_Interface serverobj = (RMI_Interface)Naming.lookup("rmi://localhost:1099/server");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.println(serverobj.add(a, b));
            a = sc.nextDouble();
            b = sc.nextDouble();
            System.out.println(serverobj.sub(a, b));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error on Client End" + e.getMessage());
            e.printStackTrace();
        }
    }
}
