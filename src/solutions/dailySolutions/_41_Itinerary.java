package src.solutions.dailySolutions;

import java.util.*;

/**
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary.
 * If no such itinerary exists, return null.
 * If there are multiple possible itineraries, return the lexicographically smallest one.
 * All flights must be used in the itinerary.
 *
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')]
 * and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 *
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
 *
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A',
 * you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
 * However, the first one is lexicographically smaller.
 */
public class _41_Itinerary {

    private static Map<String, PriorityQueue<String>> cities = new HashMap<>();
    private static List<String> route = new LinkedList<>();

    public static void main(String[] args) {
        String[][] citiesList = {
                {"A", "B"},
                {"A", "C"},
                {"B", "C"},
                {"C", "A"}
        };

        for(String[] route : citiesList) {
            String src = route[0];
            String dest = route[1];
            if(!cities.containsKey(src)) {
                cities.put(src, new PriorityQueue<>());
            }
            cities.get(src).offer(dest);
        }
        dfs("A");
        route.add(0, "A");
        System.out.println(route);
    }

    private static void dfs(String startCity) {
        PriorityQueue<String> city = cities.get(startCity);
        if(null == city || city.isEmpty())
            return;
        String newStartCity = city.poll();
        dfs(newStartCity);
        route.add(0, newStartCity);
    }
}
