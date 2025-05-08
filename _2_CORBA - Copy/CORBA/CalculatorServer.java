import CalculatorApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;

class CalculatorImpl extends CalculatorPOA {
    private ORB orb;

    public void setORB(ORB orb) { this.orb = orb; }

    @Override
    public double add(double a, double b) { return a + b; }

    @Override
    public double subtract(double a, double b) { return a - b; }

    @Override
    public double multiply(double a, double b) { return a * b; }

    @Override
    public double divide(double a, double b) { return (b != 0) ? a / b : 0; }
}

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            CalculatorImpl calcImpl = new CalculatorImpl();
            calcImpl.setORB(orb);
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calcImpl);
            Calculator href = CalculatorHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            ncRef.rebind(ncRef.to_name("Calculator"), href);

            System.out.println("Calculator Server is running...");
            orb.run();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
