package gdgoc;

import java.io.*;
import java.util.*;

// 상위 네 명 점수 합
// 가장 낮은 점수가 우승
// 여섯 명 주자 참가x의 경우 제외
// 동점이면 다섯 번째 주자가 더 낮은 점수면 우승

public class gdgoc9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, int[]> map = new HashMap<>();
            // {팀 번호 , {인원수, 1번 index, 2번 index...}}

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                if (map.containsKey(team)) {
                    int[] info = map.get(team);
                    int count = info[0];
                    info[count + 1] = i + 1;
                    info[0] = count + 1;
                    map.put(team, info);
                }
                else {
                    int[] info = new int[7];
                    info[0] = 1;
                    info[1] = i + 1;
                    map.put(team, info);
                }
            }

            int[] score = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                score[i] = i;
            }

            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] target = entry.getValue();
                if (target[0] < 6) {
                    for (int i = 1; i < target[0] + 1; i++) {
                        for (int j = target[i] + 1; j < N + 1; j++) {
                            score[j] = score[j] - 1;
                        }
                    }
                }
            }

            int minTeam = -1;
            int min = Integer.MAX_VALUE;
            int fifthIndex = Integer.MAX_VALUE;

            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int team = entry.getKey();
                int[] index = entry.getValue();

                if (index[0] < 6) continue;

                int result = 0;

                // 상위 네 명 점수 합
                for (int i = 1; i < 5; i++) {
                    result += score[index[i]];
                }

                if (min > result || (min == result && fifthIndex > index[5])) {
                    min = result;
                    minTeam = team;
                    fifthIndex = index[5];
                }
            }

            System.out.println(minTeam);
        }
    }
}
