import java.util.Scanner;

public class Tring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int token = 0;

        while (true) {
            System.out.println("Token is with process " + token);
            System.out.print("Enter process to enter critical section (-1 to exit): ");
            int process = sc.nextInt();

            if (process == -1) break;
            if (process == token) {
                System.out.println("Process " + process + " is in critical section");
                System.out.println("Process " + process + " is exiting critical section");
            } else {
                System.out.println("Process " + process + " does not have the token, cannot enter CS");
            }
            token = (token + 1) % n;
        }
        sc.close();
    }
}
