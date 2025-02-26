package Graph;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;
public class FindAllPeopleWithSecret {
    public static void main(String[] args) throws Exception {
        int n = 4;
        int[][] meetings = {
                {3, 1, 3},
                {1, 2, 2},
                {0, 3, 3}
        };
        int firstPerson = 3;
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }
    private static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> timeMeetings = new TreeMap<>();
        Set<Integer> start = new HashSet<>();
        boolean[] knowsSecret = new boolean[n];
        for (int[] meeting : meetings) {
            int p1 = meeting[0], p2 = meeting[1], time = meeting[2];
            timeMeetings.computeIfAbsent(time, k -> new ArrayList<>()).add(new int[]{p1, p2});
        }
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;
        for (int t : timeMeetings.keySet()) {
            Map<Integer, List<Integer>> meet = new HashMap<>();
            for (int[] meeting : timeMeetings.get(t)) {
                int p1 = meeting[0], p2 = meeting[1];
                meet.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
                meet.computeIfAbsent(p2, k -> new ArrayList<>()).add(p1);
            }
            for (int[] meeting : timeMeetings.get(t)) {
                int p1 = meeting[0], p2 = meeting[1];
                if (knowsSecret[p1]) {
                    start.add(p1);
                }
                if (knowsSecret[p2]) {
                    start.add(p2);
                }
            }
            Queue<Integer> q = new LinkedList<>(start);
            while (!q.isEmpty()) {
                int person = q.poll();
                for (int nextPerson : meet.getOrDefault(person, new ArrayList<>())) {
                    if (!knowsSecret[nextPerson]) {
                        knowsSecret[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }
        return result;
    }
}