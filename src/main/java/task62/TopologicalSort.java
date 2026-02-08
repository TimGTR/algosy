package task62;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(int[][] matrix) {
        int n = matrix.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                dfs(i, matrix, state, result);
            }
        }

        Collections.reverse(result);
        return result;
    }

    private static void dfs(int v, int[][] matrix, int[] state, List<Integer> result) {
        state[v] = 1; //v - текущая вершина, u - вершина, в которую ведёт ребро из v

        for (int u = 0; u < matrix.length; u++) {
            if (matrix[v][u] != 0) {
                if (state[u] == 1) {
                    throw new IllegalStateException("Граф с циклом");
                }
                if (state[u] == 0) {
                    dfs(u, matrix, state, result);
                }
            }
        }

        state[v] = 2;
        result.add(v);
    }
}
