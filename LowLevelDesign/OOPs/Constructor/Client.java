package Constructor;
public class Client {
    public static void main(String[] args) {
        User uu = new User();
        User u = new User("Arpit", 26);
        System.out.println(u.age);
        System.out.println(u.name);
        System.out.println(u.grade);
    }
}