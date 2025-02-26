public class Client {
    public static void main(String[] args) {
        final int N=1000;
        System.out.println("Name of my thread is:  "
        + Thread.currentThread().getName());
        
        for(int i=0; i<N; i++) {
            PrintNumberTask pnt =  new PrintNumberTask(i);
            Thread thread = new Thread(pnt);
            thread.start();
        }
    }
}
