package gdgoc;

import java.util.Scanner;

public class gdgoc1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] line = sc.nextLine().toUpperCase().toCharArray();
        int[] alpha = new int[26];
        int[] max = new int[2]; // index, count
        boolean isMoreThanOne = false;

        for (int i = 0; i < line.length; i++) {
            int index = line[i] - 'A';
            alpha[index] += 1;
            if (max[1] == alpha[index]) {
                isMoreThanOne = true;
            }
            if (max[1] < alpha[index]) {
                isMoreThanOne = false;
                max[0] = index;
                max[1] = alpha[index];
            }
        }

        if (isMoreThanOne) {
            System.out.println("?");
        }
        else {
            System.out.println((char) (max[0] + 'A'));
        }
    }
}
