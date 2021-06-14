package solutions.airbnb;

import java.util.*;

/**
 * We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.
 *
 * Return null if there is no such ordering.
 *
 * For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].
 */
public class _92_TopoSort_DFS {

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>());
        edges.add(Arrays.asList(0));
        edges.add(Arrays.asList(0,1));

        boolean[] visited = new boolean[3];

        for(int v =0; v <= 2; v++) {
            if(visited[v]) continue;
            topoSort(edges, v, visited);
        }

        List<Integer> order = new ArrayList<>();
        while(!st.isEmpty()) {
            order.add(0, st.pop());
        }
        System.out.println(order);
    }

    private static Stack<Integer> st = new Stack<>();
    private static void topoSort(List<List<Integer>> edges, int v, boolean[] visited) {
        visited[v] = true;
        for(int neighbor :edges.get(v)) {
            if(!visited[neighbor]) {
                topoSort(edges, neighbor,visited);
            }
        }
        st.push(v);
    }

}
