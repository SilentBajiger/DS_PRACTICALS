class TokenRingProcess extends Thread {
    private int id;
    private static int totalProcesses;
    private static int tokenHolder = 0;  
    private static final Object lock = new Object();

    public TokenRingProcess(int id, int total) {
        this.id = id;
        totalProcesses = total;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.println("Lock aquired by : " + id);
                System.out.println("STATE : " + id + " = " + Thread.currentThread().getState());
                if (tokenHolder == id) {
                    try {
                    System.out.println("Process " + id + " has the token.");
                    Thread.sleep(1000);  // time in critical section

                    System.out.println("Process " + id + " is in critical section.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Process " + id + " is leaving critical section.");
                    tokenHolder = (tokenHolder + 1) % totalProcesses;
                }
                else{
                    System.out.println("Failed cuz tokenholder is: "+tokenHolder + " tried by "+id);
                }
            }
            System.out.println("Lock Released by : " + id);
            // Allow other threads to acquire lock
            try {
                Thread.sleep(100);  // wait before checking token again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TokenRingThread {
    public static void main(String[] args) {
        int numProcesses = 5;  // You can change number of processes
        for (int i = 0; i < numProcesses; i++) {
            new TokenRingProcess(i, numProcesses).start();
        }
    }
}