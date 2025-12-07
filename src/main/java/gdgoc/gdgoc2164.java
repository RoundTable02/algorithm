package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            int next = queue.poll();
            queue.offer(next);
        }

        int result = queue.poll();
        System.out.println(result);
    }
}