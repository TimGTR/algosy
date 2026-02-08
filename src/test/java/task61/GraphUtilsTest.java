package task61;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {
    @Test
    void testSimpleGraph() {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 2},
                {3, 0, 0}
        };

        List<task61.Edge> edges = task61.GraphUtils.adjacencyMatrixToEdgeList(matrix);

        assertEquals(3, edges.size());
        assertTrue(edges.contains(new task61.Edge(0, 1, 1)));
        assertTrue(edges.contains(new task61.Edge(1, 2, 2)));
        assertTrue(edges.contains(new task61.Edge(2, 0, 3)));
    }

    @Test
    void testEmptyGraph() {
        int[][] matrix = {
                {0, 0},
                {0, 0}
        };

        List<task61.Edge> edges = task61.GraphUtils.adjacencyMatrixToEdgeList(matrix);

        assertTrue(edges.isEmpty());
    }

    @Test
    void testSingleVertex() {
        int[][] matrix = {
                {0}
        };

        List<task61.Edge> edges = task61.GraphUtils.adjacencyMatrixToEdgeList(matrix);

        assertEquals(0, edges.size());
    }

    @Test
    void testSelfLoop() {
        int[][] matrix = {
                {5}
        };

        List<task61.Edge> edges = task61.GraphUtils.adjacencyMatrixToEdgeList(matrix);

        assertEquals(1, edges.size());
        assertEquals(new task61.Edge(0, 0, 5), edges.get(0));
    }
}