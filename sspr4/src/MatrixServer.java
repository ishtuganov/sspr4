import java.io.*;
import java.net.*;

public class MatrixServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Сервер запущен, ожидает подключения...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

                    System.out.println("Клиент подключен.");
                    double[][] matrix = (double[][]) in.readObject();
                    double average = calculateAverageAboveDiagonal(matrix);
                    out.writeDouble(average);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculateAverageAboveDiagonal(double[][] matrix) {
        int n = matrix.length;
        double sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }
}
