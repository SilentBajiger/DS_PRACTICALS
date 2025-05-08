import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import MathsOp.Maths;
import MathsOp.MathsHelper;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            NamingContextExt ncref = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            Maths m = MathsHelper.narrow(ncref.resolve_str("Maths"));
            
            System.out.println(m.sub(3, 4));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error" + e.getMessage());
            e.printStackTrace();
        }
    }
}
