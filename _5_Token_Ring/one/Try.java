class Token extends Thread{
    private int id;
    public static int processes_count;
    public static final Object lock = new Object();
    public static int tokenHolder = 0;

    public Token(int id){
        this.id = id;
    }
    @Override
    public void run(){
        while(true){
            synchronized(lock){
                if(this.id == tokenHolder){
                    try {
                        System.out.println("Entering to CS :P"+id);
                        Thread.sleep(3000);
                        System.out.println("Leaving from CS :P"+id);
                        tokenHolder = (tokenHolder + 1) % processes_count;
                        System.out.println("Token Given to P"+tokenHolder);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Faild Attempt By P"+id+ "  beacuse tokenHolder is P"+tokenHolder);
                }
            }
            try {
                Thread.sleep(100);

            } catch (Exception e) {
                e.printStackTrace();
                // TODO: handle exception
            }
        }
    }

}
public class Try {
    public static void main(String[] args) {
        Token.processes_count = 5;
        for(int i = 0 ; i  < Token.processes_count ; i++){
            new Token(i).start();
        }
    }    
}
