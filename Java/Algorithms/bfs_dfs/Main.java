import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
    /**
     * Iterate through each line of input.
     */
    public static List<Double> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        // read the three lines of input
        String exchange = in.readLine();
        String source = in.readLine();
        String target = in.readLine();

        // convert the exchange rules into a map, which indicates a weighted directed graph of currency exchange
        // key is the string of starting currency, value is a Map<String, double> which stores the destination currency and exchange rate
        // ex: {"USD": {"CAD: 1.3", "JPY": 109}, "CAD": {"USD":...}, "JPY": {"USD":...}}
        Map<String, Map<String, Double>> weightedDigraph = new HashMap<>();

        for (String line: exchange.split(";")) {
            String[] splitted = line.split(",");
            String start = splitted[0];
            String end = splitted[1];
            double weight = Double.parseDouble(splitted[2]);

            // store the edges and weights into the graph
            weightedDigraph.putIfAbsent(start, new HashMap<>());
            weightedDigraph.get(start).put(end, weight);
            weightedDigraph.putIfAbsent(end, new HashMap<>());
            weightedDigraph.get(end).put(start, 1.0 / weight);
        }

        // if the source or target is not in the map, we cannot find such a path
        if (!weightedDigraph.containsKey(source) || !weightedDigraph.containsKey(target)) {
            System.out.println(-1.0);
            return;
        }
        // do a dfs on all possible paths from the source to the target, and get the max path
        dfs(weightedDigraph, source, target, new HashSet<>(), 1.0);

        if (ans.isEmpty()) {
            System.out.println(-1.0);
            return;
        }
        System.out.println(Collections.max(ans));
    }

    private static void dfs(Map<String, Map<String, Double>> graph, String start, String end, HashSet<String> visited, double cur) {

        // mark current node as visited
        visited.add(start);

        // iterate through all next-step entries
        for (Map.Entry<String, Double> entry: graph.get(start).entrySet()) {

            // if this entry has been visited, just skip this path search
            if (visited.contains(entry.getKey())) continue;
            // if this entry happens to be the end, then add current exchange rate to the ans list
            if (entry.getKey().equals(end)) {
                ans.add(cur * entry.getValue());
                continue;
            }
            // else, continue to go deep to search for the potential path
            dfs(graph, entry.getKey(), end, visited, cur * entry.getValue());
        }
    }
}