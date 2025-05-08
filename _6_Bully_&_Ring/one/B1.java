import java.util.Scanner;

public class B1 {
    private int coordinator;
    private int process_count;
    private boolean[] process;

    public B1(int no){
        process_count = no + 1;
        process = new boolean[process_count];
        for(int i = 1 ; i < process_count ; i++){
            process[i] = true;
            System.out.println("created P"+(i));
        }
    }
    public void display(){
        for(int i = 1 ; i < process_count ; i++){
            System.out.print("P"+i+ " is ");
            if (process[i]) {
                System.out.println("UP");
            }
            else {
                System.out.println("DOWN");
            }
        }
    }
    public void up(int p){
        process[p] = true;
        System.out.println("Process P"+p+ " is Up");
    }
    public void down(int p){
        process[p] = false;
        System.out.println("Process P"+p+ " is Down");
    }
    public void election(int p){
        if(p < 1 || p >= process_count ||  !process[p]){
            System.out.println("Enter Valid Process which is up");
            return;
        }
        for(int i = p; i < process_count ; i++){
            if(process[i] && i >= p){
                if(i != p)
                System.out.println("Election message sent to P" + i);
                coordinator = i;
            }
        }
        System.out.println("New Coordinator is P"+coordinator);
    }

    
    public static void main(String[] args) {

        B1 bully = null;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print(
                "\n===Bully===\n1.create \n2.display \n3.up \n4.down \n5.election \n6.exit \nEnter your choice: "
            );
            int choice;
            try{
                choice = sc.nextInt();
            }catch(Exception e){
                System.out.println("Invalid Input");
                continue;
            }
            boolean flag = false;
            switch (choice) {
                case 1:{
                    System.out.print("Enter no. of process");
                    int no = sc.nextInt();
                    bully = new B1(no);
                    break;
                }
                case 2:{
                    if(bully == null){
                        System.out.println("Create process first");
                        continue;
                    }
                    bully.display();
                    break;
                }
                case 3:{
                    if(bully == null){
                        System.out.println("Create process first");
                        continue;
                    }
                    System.out.print("Enter process to UP:");
                    int p = sc.nextInt();
                    bully.up(p);
                    break;
                }
                case 4:{
                    if(bully == null){
                        System.out.println("Create process first");
                        continue;
                    }
                    System.out.print("Enter process to Down:");
                    int p = sc.nextInt();
                    bully.down(p);
                    break;
                }
                case 5:{
                    if(bully == null){
                        System.out.println("Create process first");
                        continue;
                    }
                    System.out.print("Enter process to Run Election:");
                    int p = sc.nextInt();
                    bully.election(p);
                    break;
                }
                case 6:{
                    System.out.println("Exiting...");
                    flag = true;
                    break;
                }
                default:{
                    System.out.println("Enter valid choice");
                }
            }

            if(flag){
                break;
            }
        }
    }
}
