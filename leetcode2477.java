
/**
 * leetcode2477
 * Minimum Fuel Cost to Report to the Capital
 */
import java.util.*;

public class leetcode2477 {

    static long fuel;

    static int dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats) {
        int r = 1;
        if (!adj.containsKey(node)) {
            return r;
        }
        // System.out.println(adj.get(node));
        for (int child : adj.get(node)) {
            if (child != parent) {
                r += dfs(child, node, adj, seats);
            }
        }

        if (node != 0) {
            fuel += Math.ceil((double) r / seats);
        }
        return r;
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            if (map.containsKey(road[0])) {
                map.get(road[0]).add(road[1]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(road[1]);
                map.put(road[0], temp);
            }

            if (map.containsKey(road[1])) {
                map.get(road[1]).add(road[0]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(road[0]);
                map.put(road[1], temp);
            }
        }

        dfs(0, -1, map, seats);
        return fuel;
    }

    public static void main(String[] args) {
        int[][] roads = {
                { 3, 1 },
                { 3, 2 },
                { 1, 0 },
                { 0, 4 },
                { 0, 5 },
                { 4, 6 },
        };
        System.out.println(minimumFuelCost(roads, 2));
    }
}