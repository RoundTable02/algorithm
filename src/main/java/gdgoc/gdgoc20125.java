package gdgoc;

import java.io.*;

public class gdgoc20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean isHead = true;
        boolean isBack = false;

        int heart_i = -1;
        int heart_j = -1;

        int leftArm = -1;
        int rightArm = -1;

        int back = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                boolean isBody = line.charAt(j) == '*';
                if (isBody) {
                    if (isHead) {
                        // 머리
                        heart_i = i + 1; heart_j = j;
                        isHead = false;
                    }
                    else if (i == heart_i && leftArm == -1) {
                        // 팔 (왼쪽 시작)
                        leftArm = j;
                    }
                    else if (isBack && j == heart_j) {
                        // 허리
                        back++;
                    }
                    else if (isBack) {
                        if (j < heart_j) {
                            // 왼쪽 다리
                            leftLeg++;
                        }
                        else {
                            // 오른쪽 다리
                            rightLeg++;
                        }
                    }
                }
                else if (i == heart_i && leftArm != -1 && rightArm == -1) {
                    // 팔 (오른쪽 끝)
                    rightArm = j - 1;
                    isBack = true;
                }
            }
            // 팔 행이 끝까지 '*'로 이어진 경우
            if (i == heart_i && leftArm != -1 && rightArm == -1) {
                rightArm = line.lastIndexOf('*');
                isBack = true;
            }
        }
        int leftArmSize = heart_j - leftArm;
        int rightArmSize = rightArm - heart_j;

        int heart_result_i = heart_i + 1;
        int heart_result_j = heart_j + 1;

        System.out.println(heart_result_i + " " + heart_result_j);
        System.out.println(leftArmSize + " " + rightArmSize + " " + back + " " + leftLeg + " " + rightLeg);
    }
}

