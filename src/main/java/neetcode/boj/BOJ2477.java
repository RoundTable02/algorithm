package neetcode.boj;

// 첫 번째 줄에 1m2의 넓이에 자라는 참외의 개수를 나타내는 양의 정수 K (1 ≤ K ≤ 20)가 주어진다.
// 참외밭을 나타내는 육각형의 임의의 한 꼭짓점에서 출발하여
// 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이 (1 이상 500 이하의 정수) 가
// 둘째 줄부터 일곱 번째 줄까지 한 줄에 하나씩 순서대로 주어진다.
// 변의 방향에서 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
import java.util.*;

public class BOJ2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int melon = sc.nextInt();

        int horMaxIndex = -1;
        int verMaxIndex = -1;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            int value = sc.nextInt();
            if (direction == 1 || direction == 2) {
                if (horMaxIndex != -1) {
                    int max = list.get(horMaxIndex);
                    if (max < value) {
                        horMaxIndex = i;
                    }
                }
                else {
                    horMaxIndex = i;
                }
            }
            else {
                if (verMaxIndex != -1) {
                    int max = list.get(verMaxIndex);
                    if (max < value) {
                        verMaxIndex = i;
                    }
                }
                else {
                    verMaxIndex = i;
                }
            }
            list.add(value);
        }

        int horMinIndex = (horMaxIndex + 3) <= 5 ? horMaxIndex + 3 : horMaxIndex - 3;
        int verMinIndex = (verMaxIndex + 3) <= 5 ? verMaxIndex + 3 : verMaxIndex - 3;

        int verMaxValue = list.get(verMaxIndex);
        int horMaxValue = list.get(horMaxIndex);

        int horMinValue = list.get(horMinIndex);
        int verMinValue = list.get(verMinIndex);

        int area = verMaxValue * horMaxValue - horMinValue * verMinValue;
        System.out.println(melon * area);
    }
}
