package bojclass;

import java.io.*;
import java.util.*;

public class Main11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (Node node: arr) {
            sb.append(node.toString()).append("\n");
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node node) {
            if (this.x == node.x) return this.y - node.y;
            return this.x - node.x;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}