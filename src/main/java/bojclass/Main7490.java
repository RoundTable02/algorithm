package bojclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main7490 {
    static class Node {
        int result;
        String expression;
        int last;

        public Node(int result, String expression, int last) {
            this.result = result;
            this.expression = expression;
            this.last = last;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            // 새로운 수의 등장 -> 이전 상황에서 A를 더하거나, 빼거나, 붙이기
            // 결과, 수식의 쌍으로 저장시켜두기

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, "1", 1));

            for (int i = 2; i <= N; i++) {
                int count = queue.size();
                for (int j = 0; j < count; j++) {
                    Node node = queue.poll();

                    int newLast = node.last >= 0 ? node.last * 10 + i : node.last * 10 - i;
                    int newResult = node.result - node.last + newLast;
                    queue.add(new Node(newResult, node.expression + " " + i, newLast));

                    queue.add(new Node(node.result + i, node.expression + "+" + i, i));
                    queue.add(new Node(node.result - i, node.expression + "-" + i, -1 * i));
                }
            }

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.result == 0) sb.append(node.expression).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
