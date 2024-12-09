import java.util.Scanner;

public class MatrixApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы (n x n): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        double average = calculateAverageAboveDiagonal(matrix);
        System.out.println("Среднее арифметическое элементов выше главной диагонали: " + average);
    }

    public static double calculateAverageAboveDiagonal(int[][] matrix) {
        int sum = 0;
        int count = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return count == 0 ? 0 : (double) sum / count;
    }
}
