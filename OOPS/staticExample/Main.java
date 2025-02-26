package staticExample;
public class Main {
    // Any property of object which are not directly related to object, but common to all objects are known as Static
    public static void main(String[] args) {
        /*Main is always kept static because, if we do not keep Main method
         * as Static, then we have to make different objects of the class
         * everytime.
         * 
         * Static method can access a static data only.
         * static methods desnot depends on objects
         * 
         * We can have a static method inside a non-static method
         */

        // Human arpit = new Human(26, "Arpit Bhushan Sharma", 1400000, false);
        // Human aditya = new Human(23, "Aditya Bhushan Sharma", 400000, true); 
        // System.out.println(arpit.name);
        // System.out.println(arpit.population);
        // System.out.println(aditya.population);

        Main funn = new Main();
        funn.fun2();
    }
    
    static void fun() {
        /*we can not access non-atatic stuffs without referencing their 
        * instances in a static context
        */

        // hence, here I am referencing it.
        Main obj = new Main();
        obj.greeting();
    }

    void greeting() {
        System.out.println("Hello Guys !!");
    }

    void fun2() {
        greeting();
    }
}