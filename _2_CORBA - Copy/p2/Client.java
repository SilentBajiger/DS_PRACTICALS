import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import CalculatorOp.Calculator;
import CalculatorOp.CalculatorHelper;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt href = NamingContextExtHelper.narrow(objRef);
            Calculator calc = CalculatorHelper.narrow(href.resolve_str("Calculator"));
            System.out.println("-------");
            System.out.println(calc.add(3, 4));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
