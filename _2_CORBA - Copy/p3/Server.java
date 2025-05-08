import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import MathsOp.Maths;
import MathsOp.MathsHelper;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            MathsImpl mathsImpl = new MathsImpl();
            org.omg.CORBA.Object mref = rootPoa.servant_to_reference(mathsImpl);
            Maths href = MathsHelper.narrow(mref);

            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            ncRef.rebind(ncRef.to_name("Maths"), href);
            System.out.println("SERVER IS READY");
            orb.run();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
