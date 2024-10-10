package task2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {

            if (args.length < 2) {
               System.out.println("Необходимо указать два файла в качестве аргументов.");
               return;
           }
            double centerX = 0, centerY = 0, radius = 0;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(args[0]));
                String[] circleData = br.readLine().split(" ");
                centerX = Double.parseDouble(circleData[0]);
                centerY = Double.parseDouble(circleData[1]);
                radius = Double.parseDouble(br.readLine());
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла окружности: " + e.getMessage());
                return;
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка при закрытии файла: " + e.getMessage());
                    }
                }
            }

            br = null;
            try {
                br = new BufferedReader(new FileReader(args[1]));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] pointData = line.split(" ");
                    double pointX = Double.parseDouble(pointData[0]);
                    double pointY = Double.parseDouble(pointData[1]);
                    double distanceSquared = (pointX - centerX) * (pointX - centerX) + (pointY - centerY) * (pointY - centerY);
                    double radiusSquared = radius * radius;

                    if (distanceSquared == radiusSquared) {
                        System.out.println(0);
                    } else if (distanceSquared < radiusSquared) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла точек: " + e.getMessage());
            } finally {

                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка при закрытии файла: " + e.getMessage());
                    }
                }
            }
        }
    }

