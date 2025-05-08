import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculatorOp.Calculator;
import CalculatorOp.CalculatorHelper;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            CalculatorImpl calcImpl = new CalculatorImpl();
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(calcImpl);
            Calculator href = CalculatorHelper.narrow(ref); 

            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            ncRef.rebind(ncRef.to_name("Calculator"), href);

            System.out.println("SErver is Ready.......");
            orb.run();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
