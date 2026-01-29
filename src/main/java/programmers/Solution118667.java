package programmers;

class Solution118667 {
    public int solution(int[] queue1, int[] queue2) {
        long[] arr1 = new long[queue1.length + 1];
        long[] arr2 = new long[queue2.length + 1];
        for (int i = 1; i < queue1.length + 1; i++) {
            arr1[i] = arr1[i - 1] + queue1[i - 1];
        }
        for (int i = 1; i < queue2.length + 1; i++) {
            arr2[i] = arr2[i - 1] + queue2[i - 1];
        }
        long H = arr1[arr1.length - 1] + arr2[arr2.length - 1];
        if (H % 2 == 1) return -1;

        long K = H / 2;
        long[] t1; long[] t2;
        if (arr1[arr1.length - 1] < arr2[arr2.length - 1]) {
            t1 = arr1; t2 = arr2;
        }
        else {
            t1 = arr2; t2 = arr1;
        }

        int l = 0, r = 0;
        long T = K - t1[t1.length - 1];
        int count = 0;
        while (r < t2.length) {
            long a = t2[r];
            long b = 0;
            if (l < t1.length) b = t1[l];
            else if (l - t1.length <= r) b = t1[t1.length - 1] + t2[l - t1.length + 1];
            else break;

            long now = a - b;
            if (now == T) break;
            else if (now > T) l++;
            else r++;
            count++;
        }

        return (l - t1.length > r || r == t2.length) ? -1 : count;
    }
}
