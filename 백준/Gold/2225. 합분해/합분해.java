import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static long[][] dp; // 메모이제이션 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());;

        dp = new long[K + 1][N + 1];

        System.out.println(count(N, K));
    }

    static long count(int n, int k) {

        // 하나의 수로 n을 만드는 경우 (n 하나만 존재 -> 경우의 수 1)
        if (k == 1) {
            return 1;
        }

        // 합이 0인 경우 (모두 0만 씀)
        if (n == 0) {
            return 1;
        }

        // 이미 계산 됐으면? -> 반환
        if (dp[k][n] != 0) {
            return dp[k][n];
        }

        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += count(n - i, k - 1);
            sum %= 1000000000;
        }

        dp[k][n] = sum;
        return sum;
    }
}