import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {

        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }
        results.add(0, from);

    }

}
