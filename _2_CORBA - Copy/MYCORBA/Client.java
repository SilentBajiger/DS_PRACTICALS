import PallindromeString.*;
import PallindromeString.PallindromeHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.*;
public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Pallindrome pallindrome = PallindromeHelper.narrow(ncRef.resolve_str("Pallindrome"));
            Scanner sc = new Scanner(System.in);
            System.out.println("Client is ready to check pallindrom String...");
            boolean next = true;
            while(next){
                System.out.print("Enter your string:");
                String str = sc.nextLine();
                System.out.println("Pallindrome Status From Server: " + pallindrome.isPallindrome(str));
                System.out.print("Once more? (Y/N):");
                String more = sc.nextLine();
                if(more.charAt(0) == 'Y' || more.charAt(0) == 'y'){
                    next = true;
                }
                else next = false;
            }
            System.err.println("Thank You For Your Time...");
            sc.close();

        } catch (Exception e) { e.printStackTrace(); }
    }
}
