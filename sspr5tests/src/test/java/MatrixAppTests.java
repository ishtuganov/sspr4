import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixAppTests {

    @Test
    public void testCalculateAverageAboveDiagonal_case1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double result = MatrixApp.calculateAverageAboveDiagonal(matrix);
        assertEquals(3.666, result, 0.001);
    }

    @Test
    public void testCalculateAverageAboveDiagonal_case2() {
        int[][] matrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        double result = MatrixApp.calculateAverageAboveDiagonal(matrix);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageAboveDiagonal_case3() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        double result = MatrixApp.calculateAverageAboveDiagonal(matrix);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageAboveDiagonal_case4() {
        int[][] matrix = {
                {1}
        };
        double result = MatrixApp.calculateAverageAboveDiagonal(matrix);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageAboveDiagonal_case5() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        double result = MatrixApp.calculateAverageAboveDiagonal(matrix);
        assertEquals(6.0, result, 0.001); // (2 + 3 + 7 + 8 + 10 + 11) / 6 = 9.0
    }

    @Test
    public void testCalculateAverageAboveDiagonal_case6() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        double result = MatrixApp.calculateAverageAboveDiagonal(matrix);
        assertEquals(0.0, result, 0.001);
    }
}
