import java.util.*;

public class Ring {
    int max_processes;
    int coordinator;
    boolean processes[];
    ArrayList<Integer> pid;

    public Ring(int max) {
        coordinator = max;
        max_processes = max;
        pid = new ArrayList<>();
        processes = new boolean[max];

        for (int i = 0; i < max; i++) {
            processes[i] = true;  // All processes are initially alive
            System.out.println("P" + (i + 1) + " created.");
        }
        System.out.println("P" + coordinator + " is the initial coordinator.");
    }

    void displayProcesses() {
        for (int i = 0; i < max_processes; i++) {
            if (processes[i])
                System.out.println("P" + (i + 1) + " is up.");
            else
                System.out.println("P" + (i + 1) + " is down.");
        }
        System.out.println("Current Coordinator: P" + coordinator);
    }

    void upProcess(int process_id) {
        if (process_id < 1 || process_id > max_processes) {
            System.out.println("Invalid process ID.");
            return;
        }
        if (!processes[process_id - 1]) {
            processes[process_id - 1] = true;
            System.out.println("Process P" + process_id + " is now up.");
        } else {
            System.out.println("Process P" + process_id + " is already up.");
        }
    }

    void downProcess(int process_id) {
        if (process_id < 1 || process_id > max_processes) {
            System.out.println("Invalid process ID.");
            return;
        }
        if (!processes[process_id - 1]) {
            System.out.println("Process P" + process_id + " is already down.");
        } else {
            processes[process_id - 1] = false;
            System.out.println("Process P" + process_id + " is down.");
        }
    }

    void displayArrayList(ArrayList<Integer> pid) {
        System.out.print("[ ");
        for (Integer x : pid) {
            System.out.print(x + " ");
        }
        System.out.print("]\n");
    }

    void initElection(int process_id) {
        if (process_id < 1 || process_id > max_processes || !processes[process_id - 1]) {
            System.out.println("Invalid process ID or process is down.");
            return;
        }

        System.out.println("Process P" + process_id + " started election.");
        pid.clear(); // Clear previous elections
        pid.add(process_id);

        int temp = (process_id) % max_processes; // Start election in the next process

        while (temp != process_id - 1) {
            if (processes[temp]) {
                pid.add(temp + 1);
                System.out.print("Process P" + (temp + 1) + " sending the following list: ");
                displayArrayList(pid);
            }
            temp = (temp + 1) % max_processes;
        }

        // The highest process ID becomes the new coordinator
        coordinator = Collections.max(pid);
        System.out.println("Process P" + process_id + " has declared P" + coordinator + " as the new coordinator.");
        pid.clear();  // Clear for next election
    }

    public static void main(String args[]) {
        Ring ring = null;
        int max_processes = 0, process_id = 0;
        int choice;
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
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the total number of processes: ");
                    max_processes = sc.nextInt();
                    ring = new Ring(max_processes);
                    break;
                case 2:
                    if (ring != null) ring.displayProcesses();
                    else System.out.println("Create processes first.");
                    break;
                case 3:
                    System.out.print("Enter the process to up: ");
                    process_id = sc.nextInt();
                    if (ring != null) ring.upProcess(process_id);
                    else System.out.println("Create processes first.");
                    break;
                case 4:
                    System.out.print("Enter the process to down: ");
                    process_id = sc.nextInt();
                    if (ring != null) ring.downProcess(process_id);
                    else System.out.println("Create processes first.");
                    break;
                case 5:
                    System.out.print("Enter the process which will initiate election: ");
                    process_id = sc.nextInt();
                    if (ring != null) {
                        ring.initElection(process_id);
                        ring.displayProcesses();
                    } else {
                        System.out.println("Create processes first.");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
