package gdgoc;

import java.util.*;

public class gdgoc5073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] s = sc.nextLine().split(" ");
            Set<String> set = new HashSet<>(List.of(s));
            if (set.size() == 1 && set.contains("0")) {
                break;
            }

            Queue<Integer> queue = new PriorityQueue<>();
            for (String string : s) {
                queue.add(Integer.valueOf(string));
            }
            int min1 = queue.poll();
            int min2 = queue.poll();
            int max = queue.poll();
            if (max >= min1 + min2) {
                System.out.println("Invalid");
            } else {
                if (set.size() == 1) {
                    System.out.println("Equilateral");
                } else if (set.size() == 2) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}
