class Process extends Thread {
    private int id;
    private boolean hasToken;
    private boolean requestCS;
    private Process next;

    public Process(int id) {
        this.id = id;
        this.hasToken = false;
        this.requestCS = false;
    }

    public void setNext(Process next) {
        this.next = next;
    }

    public void requestCriticalSection() {
        this.requestCS = true;
    }

    public void receiveToken() {
        this.hasToken = true;
    }

    public void run() {
        while (true) {
            if (hasToken) {
                if (requestCS) {
                    enterCriticalSection();
                    exitCriticalSection();
                    requestCS = false;
                }
                passToken();
            }

            try {
                Thread.sleep(500);  // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void enterCriticalSection() {
        System.out.println("Process " + id + " is entering the critical section.");
    }

    private void exitCriticalSection() {
        System.out.println("Process " + id + " is exiting the critical section.");
    }

    private void passToken() {
        hasToken = false;
        System.out.println("Process " + id + " is passing the token to Process " + next.id);
        next.receiveToken();
    }
}

public class TokenRingSimulation {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;  // number of processes
        Process[] processes = new Process[n];

        // Create and link processes in a ring
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(i);
        }
        for (int i = 0; i < n; i++) {
            processes[i].setNext(processes[(i + 1) % n]);
        }

        // Assign token to Process 0
        processes[0].receiveToken();

        // Start all threads
        for (int i = 0; i < n; i++) {
            processes[i].start();
        }

        // Request critical section from Process 2 after some delay
        Thread.sleep(2000);
        processes[2].requestCriticalSection();
    }
}
