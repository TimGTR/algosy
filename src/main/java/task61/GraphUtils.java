package task61;


import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

    public static List<task61.Edge> adjacencyMatrixToEdgeList(int[][] matrix) {
        List<task61.Edge> edges = new ArrayList<>();

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    edges.add(new task61.Edge(i, j, matrix[i][j]));
                }
            }
        }

        return edges;
    }
}
