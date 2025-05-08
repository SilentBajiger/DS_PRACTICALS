import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalcOp.Calc;
import CalcOp.CalcHelper;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            CalcImpl calcImpl = new CalcImpl();
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(calcImpl);
            Calc calcRef = CalcHelper.narrow(ref);

            NamingContextExt ncref = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            ncref.rebind(ncref.to_name("Calc"), calcRef);
            System.out.println("SERVER IS READY.........");
            orb.run();


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
