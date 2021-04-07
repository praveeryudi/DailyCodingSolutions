package src.solutions.myOwn;

import java.util.Stack;

public class ConnectedComponents {

    private static void dfs(int vertex, int[][] edges, boolean[] visited) {

        Stack<Integer> st = new Stack<>();
        st.push(vertex);
        visited[vertex] = true;
        while(!st.isEmpty()) {
            int v = st.pop();
            int[] neighbors = edges[v];
            for(int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    st.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    private static void dfsRecursive(int vertex, int[][] edges, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        int[] neighbors = edges[vertex];
        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                dfsRecursive(neighbor, edges, visited);
            }
        }
    }

    private static int getComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        int components = 0;
        for(int v = 0; v < n; v++) {
            if(visited[v])
                continue;

            //visited[v] = true;
            dfs(v, edges, visited);
            components += 1;
            System.out.println("");
        }
        return components;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1},
                {0,2},
                {1},
                {4},
                {3}
        };
        int res = getComponents(5, edges);
        System.out.println("# of connected components: " + res);
    }

}
