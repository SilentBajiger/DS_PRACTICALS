import PallindromeString.*;
import PallindromeString.PallindromePOA;
import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;

class PallindromeImpl extends PallindromePOA {
    private ORB orb;
    public void setORB(ORB orb) { this.orb = orb; }
    @Override
    public boolean isPallindrome(String str) {
        System.out.println("String received from client : " + str);
        for(int i =0, j = str.length() - 1 ; i < j ; i++ ,j --){
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            PallindromeImpl palImpl = new PallindromeImpl();
            palImpl.setORB(orb);
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(palImpl);
            Pallindrome href = PallindromeHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            ncRef.rebind(ncRef.to_name("Pallindrome"), href);
            System.out.println("Pallindrome Checker Server is Listening...");
            orb.run();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
