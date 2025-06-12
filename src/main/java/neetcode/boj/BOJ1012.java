package neetcode.boj;

import java.io.*;

public class BOJ1012 {

    static int N;
    static int MAX = 1;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                search();
                swap(i, j, i + 1, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j, i, j + 1);
            }
        }

        System.out.println(MAX);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static void search() {

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if(arr[i+1][j] == arr[i][j]) {
                    count++;
                    MAX = Math.max(MAX, count);
                } else {
                    count = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if(arr[i][j+1] == arr[i][j]) {
                    count++;
                    MAX = Math.max(MAX, count);
                } else {
                    count = 1;
                }
            }
        }
    }
}