package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        Deque deque = new Deque();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    int valueFront = Integer.parseInt(st.nextToken());
                    deque.pushFront(valueFront);
                    break;
                case "push_back":
                    int valueBack = Integer.parseInt(st.nextToken());
                    deque.pushBack(valueBack);
                    break;
                case "pop_front":
                    System.out.println(deque.popFront());
                    break;
                case "pop_back":
                    System.out.println(deque.popBack());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(deque.front());
                    break;
                case "back":
                    System.out.println(deque.back());
                    break;
            }
        }
    }

    public static class Deque {
        LinkedList<Integer> queue = new LinkedList<>();
        public void pushFront(int value) {
            queue.addFirst(value);
        }
        public void pushBack(int value) {
            queue.addLast(value);
        }
        public int popFront() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.removeFirst();
        }
        public int popBack() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.removeLast();
        }
        public int size() {
            return queue.size();
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
        public int front() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.getFirst();
        }
        public int back() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.getLast();
        }
    }
}

