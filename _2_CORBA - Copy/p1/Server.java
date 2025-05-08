import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculatorAdd.Calculator;
import CalculatorAdd.CalculatorHelper;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            CalculatorImpl palImpl = new CalculatorImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(palImpl);
            Calculator href = CalculatorHelper.narrow(ref);

            NamingContextExt ncRef = NamingContextExtHelper.narrow(
                    orb.resolve_initial_references("NameService"));
            ncRef.rebind(ncRef.to_name("Calculator"), href);

            System.out.println("Server ready...");
            orb.run();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
