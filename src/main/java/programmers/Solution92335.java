package programmers;

class Solution92335 {
    public int solution(int n, int k) {
        // k진수 변환
        String converted = Integer.toString(n, k);

        // 0 기준 분리
        String[] parts = converted.split("0");

        int answer = 0;
        for (String p : parts) {
            if (p.isEmpty()) continue;

            long num = Long.parseLong(p);
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

