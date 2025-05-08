import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import CalcOp.Calc;
import CalcOp.CalcHelper;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            NamingContextExt ncref = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            Calc calc = CalcHelper.narrow(ncref.resolve_str("Calc"));
            System.out.println(calc.add(3, 90));
        } catch (Exception e) {
            
            System.out.println(e);
            e.printStackTrace();// TODO: handle exception
        }
    }
}
