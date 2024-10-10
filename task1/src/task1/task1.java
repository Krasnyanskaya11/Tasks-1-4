package task1;
import java.util.Scanner;

public class task1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите кол-во элементов в массиве - n:");
            int n = scanner.nextInt();
            System.out.println("Введите длину обхода - m:");
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            System.out.println(".");

            System.out.print("При длине обхода " + m + " получаем интервалы: ");
            for (int i = 0; i < n; i += m-1) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[(i + j) % n]);
                }
                if (i + m < n) {
                    System.out.print(", ");
                }
            }
            System.out.println(".");

            System.out.print("Полученный путь: ");
            for (int i = 0; i < (n + m - 1) / m; i++) {
                System.out.print(arr[(i * (m-1)) % n]);
            }
            System.out.println();
        }
    }







