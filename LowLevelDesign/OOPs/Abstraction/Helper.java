package Abstraction;
public class Helper {
    public static void main(String[] args) {
        // Objects
        Student virat = new Student();
        Student rohit = new Student();
        
        virat.name = "Virat Kohli";
        virat.psp = 100.0; // Added .0 to make it a Double
        virat.age = 30;
        virat.gender = "Male";
        virat.attendClass(); // Added to show usage of the attendClass method

        rohit.name = "Rohit Sharma";
        rohit.psp = 80.1;
        rohit.age = 26;
        rohit.gender = "Male";
        rohit.attendClass(); // Added to show usage of the attendClass method

        System.out.println("PSP of Virat Kohli = " + virat.getPSP());
        System.out.println("PSP of Rohit Sharma = " + rohit.getPSP());
    }
}