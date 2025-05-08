import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String ServerUrl = "rmi://localhost:1099/MainServer";
            // String ServerUrl = "rmi://localhost/MainServer";
            RMI_Interface serverObj = (RMI_Interface)Naming.lookup(ServerUrl);

            double num1 , num2;
            System.out.print("Enter num1 : ");
            num1 = sc.nextDouble();
            System.out.print("Enter num2 : ");
            num2 = sc.nextDouble();
            
            double addition = (double)serverObj.add(num1, num2);
            double substraction = (double)serverObj.sub(num1, num2);

            System.out.println("Addition is : " + addition);
            System.out.println("Substraction is : " + substraction);

        } catch (Exception e) {
            System.out.println("Error at Client Side " + e.getMessage());
        }
        sc.close();
    }
}
