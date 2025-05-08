import java.util.concurrent.TimeUnit;
import java.util.Scanner;
public class TokenRing {
    static int numProcesses;  // Total number of processes in the ring
    static int token = 0;  // Initially, process 0 has the token
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of node : ");
        numProcesses = sc.nextInt();
        while (true) {
            // The process that holds the token can enter the Critical Section
            System.out.println("Process " + token + " has the token.");

            // 🔴 CRITICAL SECTION (CS) STARTS
            System.out.println("Process " + token + " is entering the Critical Section...");
            try {
                TimeUnit.SECONDS.sleep(5); // Simulating Critical Section execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process " + token + " is exiting the Critical Section.");
            // 🔴 CRITICAL SECTION (CS) ENDS

            // Pass the token to the next process in the ring
            token = (token + 1) % numProcesses;

            try {
                TimeUnit.SECONDS.sleep(1); // Simulating token passing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
