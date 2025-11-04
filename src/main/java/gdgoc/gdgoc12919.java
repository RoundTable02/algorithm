package gdgoc;

import java.util.*;

public class gdgoc12919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();

        Queue<String> queue = new LinkedList<>();
        queue.offer(T);
        while (!queue.isEmpty()) {
            String target = queue.poll();
            if (target.equals(S)) {
                System.out.println("1");
                return;
            }

            if (target.length() > 1) {
                if (target.charAt(target.length() - 1) == 'A') {
                    queue.offer(target.substring(0, target.length() - 1));
                }
                if (target.charAt(0) == 'B') {
                    StringBuffer sb = new StringBuffer(target.substring(0, target.length()));
                    String reverse = sb.reverse().toString();
                    queue.offer(reverse.substring(0, reverse.length() - 1));
                }
            }
        }
        System.out.println("0");
    }
}
