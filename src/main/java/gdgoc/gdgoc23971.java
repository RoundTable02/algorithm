package gdgoc;

import java.util.Scanner;

public class gdgoc23971 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        int H = Integer.parseInt(line[0]);
        int W = Integer.parseInt(line[1]);
        int N = Integer.parseInt(line[2]);
        int M = Integer.parseInt(line[3]);

        int rows = (H - 1) / (N + 1) + 1;
        int columns = (W - 1) / (M + 1) + 1;

        System.out.println(rows * columns);
    }
}
