import CalculatorApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            Calculator calc = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));

            System.out.println("Addition: " + calc.add(10, 5));
            System.out.println("Subtraction: " + calc.subtract(10, 5));
            System.out.println("Multiplication: " + calc.multiply(10, 5));
            System.out.println("Division: " + calc.divide(10, 5));

        } catch (Exception e) { e.printStackTrace(); }
    }
}
