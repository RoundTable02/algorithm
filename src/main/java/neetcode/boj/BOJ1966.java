package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ1966 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            int count = 0;
            LinkedList<Pair> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                int token = Integer.parseInt(st.nextToken());
                queue.offer(new Pair(j, token));
            }

            while(!queue.isEmpty()) {
                int target = -1;
                Pair front = queue.poll();
                for (int j = 0; j < queue.size(); j++) {
                    if (queue.get(j).weight > front.weight) {
                        target = j;
                        break;
                    }
                }
                if (target != -1) {
                    queue.offer(front);
                    for (int j = 0; j < target; j++) {
                        queue.offer(queue.poll());
                    }
                }
                else {
                    count++;
                    if (front.index == index) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }


    }

    static class Pair {
        int index;
        int weight;
        public Pair(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
