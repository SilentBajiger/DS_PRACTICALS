import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class R {
    private int process_count;
    private int coordinator;
    private boolean[] process;
    private ArrayList<Integer> pid = null;
    R(int n){
        process_count = n + 1;
        process = new boolean[process_count];
        for(int i = 1 ; i < process_count ; i++){
            System.out.println("P"+i+ " is created");
            process[i] = true;
        }
    }

    void display(){
        for(int i = 1 ; i < process_count ; i++){
            System.out.print("P1 is ");
            if(process[i]){
                System.out.println("UP");
            }
            else System.out.println(" DOWN");
        }   
    }
    void up(int p){
        if(p < 1  || p >= process_count || process[p]){
            System.out.println("Enter valid process which is down");
            return;
        }
        process[p] = true;
        System.out.println("PROCESS P"+p+" is up");
    }

    void down(int p){
        if(p < 1  || p >= process_count || !process[p]){
            System.out.println("Enter valid process which is up");
            return;
        }
        process[p] = false;
        System.out.println("PROCESS P"+p+" is down");
    }

    void election(int p){
        if(p < 1  || p >= process_count || !process[p]){
            System.out.println("Enter valid process which is up");
            return;
        }
        System.out.println("Ererer");
        pid = new ArrayList<>();
        System.out.println("Ererer1");

        pid.add(p);

        System.out.println("Ererer2");

        int i = (p + 1) % process_count;
        int prev = p;
        while (i != p - 1) {
            if( process[i] && i > p){
                pid.add(i);
                System.out.print("P"+prev+" send list to P"+(i));
                System.out.println("  List is: "+pid);
                prev = i;
            }                    
            i = (i + 1) % process_count;
        }
        coordinator = Collections.max(pid);
        System.out.println("new coordinator is: P"+coordinator);
    }

    public static void main(String[] args) {
        R r = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nRing Algorithm");
            System.out.println("1. Create processes");
            System.out.println("2. Display processes");
            System.out.println("3. Up a process");
            System.out.println("4. Down a process");
            System.out.println("5. Run election algorithm");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            boolean flag = false;
            switch (choice){
                case 1:{
                    System.out.print("enter no .of process");
                    int n = sc.nextInt();
                    r = new R(n);
                    break;
                }
                case 2:{
                    if(r == null){
                        System.out.println("Create the procees first");
                        break;
                    }
                    r.display();
                    break;
                }
                case 3:{
                    if(r == null){
                        System.out.println("Create the procees first");
                        break;
                    }
                    System.out.print("Enter process Id to up: ");
                    int p = sc.nextInt();
                    r.up(p);
                    break;
                }
                case 4:{
                    if(r == null){
                        System.out.println("Create the procees first");
                        break;
                    }
                    System.out.print("Enter process Id to Down: ");
                    int p = sc.nextInt();
                    r.down(p);
                    break;
                }
                case 5:{
                    if(r == null){
                        System.out.println("Create the procees first");
                        break;
                    }
                    System.out.print("Enter process Id to start Election: ");
                    int p = sc.nextInt();
                    r.election(p);
                    break;
                }
                case 6:{
                    System.out.println("Exiting......");
                    flag = true;
                    break;
                }
                default:{
                    System.out.println("Enter valid choice");
                }
            }
            if(flag) break;
        }
    }
}
