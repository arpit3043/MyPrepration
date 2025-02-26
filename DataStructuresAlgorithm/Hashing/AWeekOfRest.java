package Hashing;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.temporal.ChronoField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.String;
public class AWeekOfRest {
    public static void main(String[] args) throws Exception {
        Thread[] weekDayThreads;
        try {
            AWeekOfRest rest = new AWeekOfRest();
            weekDayThreads = rest.getWeekDay();
            for (Thread thread : weekDayThreads) {
                thread.start();
            }
            for (Thread thread : weekDayThreads) {
                thread.join();
            }
            System.out.println("Hash map populated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    private static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private static Map<String, String> map = new ConcurrentHashMap<>();;
    private static AtomicInteger counter = new AtomicInteger(0);
    private static LocalDate startDate = LocalDate.of(2021, 10, 8);
    private static Thread[] getWeekDay() throws Exception {
        Thread[] weekDay = new Thread[16];
        for (int i = 0; i < weekDay.length; i++) {
            weekDay[i] = new Thread(() -> {
                int next = AWeekOfRest.counter.getAndIncrement();
                while (next < 7000) {
                    LocalDate currDate = startDate.plusDays(next);
                    String key = currDate.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
                    String value = day[currDate.get(ChronoField.DAY_OF_WEEK) == 7 ? 0 : currDate.get(ChronoField.DAY_OF_WEEK)];
                    AWeekOfRest.map.put(key, value);
                    next = AWeekOfRest.counter.getAndIncrement();
                }
            });
        }
        return weekDay;
    }
}