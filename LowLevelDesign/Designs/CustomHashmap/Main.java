package Designs.CustomHashmap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CustomHashMap<Character, Integer> map = new CustomHashMap<>();
        CustomHashMap.setGlobalTTLSeconds(5); // TTL set to 5 seconds

        map.put('A', 100);
        System.out.println("Get A: " + map.get('A')); // Should return 100

        Thread.sleep(6000);
        System.out.println("Get A after TTL: " + map.get('A')); // Should return null
    }
}