import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("123");
        queue.add("244");
        queue.add("32");
        queue.add("155");
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {

        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }
        results.add(0, from);

    }

}
