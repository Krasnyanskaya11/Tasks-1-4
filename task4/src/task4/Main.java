package task4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;;
public class Main {

    public static void main(String[] args) {

        String filePath = args[0];
        int sum = 0, count = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                sum += num;
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file: " + e.getMessage());
                }
            }
        }

        int average = sum / count;
        int moves = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                moves += Math.abs(Integer.parseInt(line.trim()) - average);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file: " + e.getMessage());
                }
            }
        }

        System.out.println(moves);
    }
    }

