import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MatrixClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Введите размер матрицы (n x n): ");
            int n = scanner.nextInt();
            double[][] matrix = new double[n][n];

            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextDouble();
                }
            }

            out.writeObject(matrix);
            out.flush();

            double average = in.readDouble();
            System.out.println("Среднее арифметическое элементов выше главной диагонали: " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
