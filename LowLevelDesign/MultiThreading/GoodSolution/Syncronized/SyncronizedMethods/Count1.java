package MultiThreading.GoodSolution.Syncronized.SyncronizedMethods;

public class Count1 {
    private int value=0;
    /**
     * sync methods : are basically they allow only thread to take a lock on ALL
     * SYNC METHODS AT ONE POINT.
     * @param offset
     */
    // u1 --->
    // u2
    public synchronized void incrementValue(int offset){
        this.value +=offset;
    }
    public synchronized void decrement(int offset){
        this.value +=offset;
    }
    /**
     *
     * above methods are thread safe...
     */
    public int getValue(){
        return this.value;
    }
}
