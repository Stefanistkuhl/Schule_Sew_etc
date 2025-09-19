public class ThreadBsp extends Thread{
    public void run(){
        for (int i = 0; i < 15; i++) {
            System.out.println("thread: "+i);
        }
    }

    public static void main(String[] args) {
        ThreadBsp t1 = new ThreadBsp();
        t1.start();
        for (int i = 0; i < 15; i++) {
            System.out.println("main: "+i);
        }
    }

}
