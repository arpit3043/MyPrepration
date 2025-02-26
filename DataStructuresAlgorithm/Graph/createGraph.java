package Graph;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.lang.String;
import java.lang.Integer;
import java.lang.Character;
class createGraph {
    public static void main(String[] args) {
        Graph<Character> g = new Graph<>();
        g.addEdge('0', '1', 4, false);
        g.addEdge('0', '7', 8, false);
        g.addEdge('1', '7', 11, false);
        g.addEdge('1', '2', 8, false);
        g.addEdge('7', '8', 7, false);
        g.addEdge('2', '8', 2, false);
        g.addEdge('8', '6', 6, false);
        g.addEdge('2', '5', 4, false);
        g.addEdge('6', '5', 2, false);
        g.addEdge('2', '3', 7, false);
        g.addEdge('3', '3', 14, false);
        g.addEdge('3', '4', 9, false);
        g.addEdge('5', '4', 10, false);
        g.addEdge('7', '6', 1, false);
        g.printAdj();
    }
    private static class Graph<T> {
        private Map<T, List<Pair<T, Integer>>> adjList = new HashMap<>();
        private void addEdge(T u, T v, int dist, boolean bidirec) {
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, dist));
            if (bidirec) {
                adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, dist));
            }
        }
        private void printAdj() {
            for (Map.Entry<T, List<Pair<T, Integer>>> entry : adjList.entrySet()) {
                System.out.print(entry.getKey() + " : ");
                for (Pair<T, Integer> pair : entry.getValue()) {
                    System.out.print("( " + pair.getFirst() + " , " + pair.getSecond() + " ) ");
                }
                System.out.println();
            }
        }
        private void bfs(T u) {
            Map<T, Boolean> visited = new HashMap<>();
            Queue<T> q = new LinkedList<>();
            q.add(u);
            while (!q.isEmpty()) {
                T frontElement = q.poll();
                if (!visited.getOrDefault(frontElement, false)) {
                    System.out.print(frontElement + " -> ");
                    visited.put(frontElement, true);
                }
                for (Pair<T, Integer> pair : adjList.get(frontElement)) {
                    if (!visited.getOrDefault(pair.getFirst(), false)) {
                        q.add(pair.getFirst());
                    }
                }
            }
        }
        private void dfsHelper(T src, Map<T, Boolean> visited) {
            visited.put(src, true);
            System.out.print(src + " -> ");
            for (Pair<T, Integer> pair : adjList.get(src)) {
                if (!visited.getOrDefault(pair.getFirst(), false)) {
                    dfsHelper(pair.getFirst(), visited);
                }
            }
        }
        private void dfsUtility(T src) {
            Map<T, Boolean> visited = new HashMap<>();
            dfsHelper(src, visited);
        }
        private void bfsSSSP(T src) {
            Map<T, Integer> distance = new HashMap<>();
            Map<T, T> parent = new HashMap<>();
            for (T key : adjList.keySet()) {
                distance.put(key, Integer.MAX_VALUE);
            }
            Queue<T> q = new LinkedList<>();
            q.add(src);
            distance.put(src, 0);
            parent.put(src, src);
            while (!q.isEmpty()) {
                T frontElement = q.poll();
                for (Pair<T, Integer> pair : adjList.get(frontElement)) {
                    if (distance.get(pair.getFirst()) == Integer.MAX_VALUE) {
                        q.add(pair.getFirst());
                        distance.put(pair.getFirst(), distance.get(frontElement) + 1);
                        parent.put(pair.getFirst(), frontElement);
                    }
                }
            }
            for (T key : adjList.keySet()) {
                System.out.println("Distance to " + key + " from " + src + " is " + distance.get(key));
            }
            T temp = (T) (Character) 'g';
            while (!parent.get(temp).equals(temp)) {
                System.out.print(temp + " <-- ");
                temp = parent.get(temp);
            }
            System.out.println(src);
        }
        private void dijkstra(T src) {
            Map<T, Integer> dist = new HashMap<>();
            for (T key : adjList.keySet()) {
                dist.put(key, Integer.MAX_VALUE);
            }
            Set<Pair<Integer, T>> s = new TreeSet<>(Comparator.comparingInt(Pair::getFirst));
            s.add(new Pair<>(0, src));
            dist.put(src, 0);
            while (!s.isEmpty()) {
                Pair<Integer, T> p = s.iterator().next();
                int nodeDist = p.getFirst();
                T temp = p.getSecond();
                s.remove(p);
                for (Pair<T, Integer> pair : adjList.get(temp)) {
                    if (nodeDist + pair.getSecond() < dist.get(pair.getFirst())) {
                        Pair<Integer, T> f = null;
                        for (Pair<Integer, T> pairInSet : s) {
                            if (pairInSet.getSecond().equals(pair.getFirst())) {
                                f = pairInSet;
                                break;
                            }
                        }
                        if (f != null) {
                            s.remove(f);
                        }
                        dist.put(pair.getFirst(), nodeDist + pair.getSecond());
                        s.add(new Pair<>(dist.get(pair.getFirst()), pair.getFirst()));
                    }
                }
            }
            for (Map.Entry<T, Integer> entry : dist.entrySet()) {
                System.out.println(entry.getKey() + " and " + entry.getValue());
            }
        }
    }
    private static class Pair<T, U> {
        private final T first;
        private final U second;
        private Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
        private T getFirst() {
            return first;
        }
        private U getSecond() {
            return second;
        }
    }
}