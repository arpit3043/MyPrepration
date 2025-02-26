package Inheritance;
public class Main {
    public static void main(String[] args) throws Exception {
        // BoxWeight box4 = new BoxWeight();
        // System.out.println(box4.h + "  " + box4.weight);

        // BoxWeight box5 = new BoxWeight(2,3,4,8);
        // Box box6 = new Box(box5);

        // Box box = new Box();
        // Box box1 = new Box(4);
        // Box box2 = new Box(4.6, 7.9, 9.9);
        // Box box3 = new Box(box2);
        
        // System.out.println(box.l + " "  + box.w + " " + box.h);
        // System.out.println(box1.l + " " + box1.w + " " + box1.h);
        // System.out.println(box2.l + " " + box2.w + " " + box2.h);
        // System.out.println(box3.l + " " + box3.w + " " + box3.h);

        // Box box7 = new BoxWeight(2,3,4,8); 
        // System.out.println(box7.w);

        /* There are many variables in both parent and child class
        you are given access tp variables that are in the reference type
        i.e., BoxWeight
        hence, you should have access tp weight variable
        this also means, that the ones you are trying to access should be initialised
        but here, when the obj is itself is of the type parent class,
        How will you call the constructor of child class
        That's why the error occured
        */
        // BoxWeight box8 = new Box(2, 3, 4);

        BoxPrice box = new BoxPrice(5, 8, 200);
    } 
}
