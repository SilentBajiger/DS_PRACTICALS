import java.io.*;
import java.util.*;

class Ring {

    public static void main(String args[]) throws Throwable {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Process : ");
        int count = sc.nextInt();
        int token = 0;
        while(true){
            System.out.println("Token is with process no. " + token);
            System.out.print("Which process should enter into CS  (-1 to exit): ");
            int process = sc.nextInt();
            if(process == -1) break;
            if(process == token){
                System.out.println(token + "Entered into CS");
                System.out.println(token + "Exited from CS");
            }
            else{
                System.out.println(process + " dont have token so cannot enter into CS");
            }
            token = (token + 1) % count;
        }
        sc.close();
    }

}
