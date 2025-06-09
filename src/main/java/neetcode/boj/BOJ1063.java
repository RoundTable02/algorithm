package neetcode.boj;

import java.time.LocalDate;
import java.util.Scanner;

public class BOJ1063 {
    static int[] kingPos = {0, 0};
    static int[] stonePos = {0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String king = sc.next();
        String stone = sc.next();
        int n = sc.nextInt();

        kingPos = new int[]{king.charAt(0) - 'A', king.charAt(1) - '1'};
        stonePos = new int[]{stone.charAt(0) - 'A', stone.charAt(1) - '1'};

        int[] R = {1, 0}; // 오른쪽
        int[] L = {-1, 0}; // 왼쪽
        int[] B = {0, -1}; // 아래
        int[] T = {0, 1}; // 위
        int[] RT = {1, 1}; // 오른쪽 위
        int[] RB = {1, -1}; // 오른쪽 아래
        int[] LT = {-1, 1}; // 왼쪽 위
        int[] LB = {-1, -1}; // 왼쪽 아래

        for(int i = 0; i < n; i++) {
            String command = sc.next();
            switch(command) {
                case "R" :
                    move(R);
                    break;
                case "L" :
                    move(L);
                    break;
                case "B" :
                    move(B);
                    break;
                case "T" :
                    move(T);
                    break;
                case "RT":
                    move(RT);
                    break;
                case "RB":
                    move(RB);
                    break;
                case "LT":
                    move(LT);
                    break;
                case "LB":
                    move(LB);
                    break;
                default: break;
            }
        }

        printPosition();
    }

    private static void printPosition() {
        char kingCol = (char) (kingPos[0] + 'A');
        char kingRow = (char) (kingPos[1] + '1');
        char stoneCol = (char) (stonePos[0] + 'A');
        char stoneRow = (char) (stonePos[1] + '1');

        System.out.println(kingCol + "" + kingRow);
        System.out.println(stoneCol + "" + stoneRow);
    }

    private static boolean move(int[] command) {
        int[] nextKing = {kingPos[0] + command[0], kingPos[1] + command[1]};
        if(nextKing[0] < 0 || nextKing[0] >= 8) {
            return true;
        }
        if(nextKing[1] < 0 || nextKing[1] >= 8) {
            return true;
        }
        if(nextKing[0]==stonePos[0] && nextKing[1]==stonePos[1]) {
            int[] nextStone = {stonePos[0] + command[0], stonePos[1] + command[1]};
            if(nextStone[0] < 0 || nextStone[0] >= 8) {
                return true;
            }
            if(nextStone[1] < 0 || nextStone[1] >= 8) {
                return true;
            }
            stonePos = nextStone;
        }

        kingPos = nextKing;
        printPosition();
        return false;
    }
}

/**
 * R
 * L
 * B
 * T
 * RT
 * RB
 * LT
 * LB
 */