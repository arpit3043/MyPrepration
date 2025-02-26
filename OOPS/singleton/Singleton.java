package singleton;
public class Singleton {
    // Class which can create only one object
    private int num = 0;
    Singleton() {
        System.out.println("Inside Singleton");
    }

    private static Singleton instance;

    public static Singleton getInstance() {
        // check weather 1 obj is created or not
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
