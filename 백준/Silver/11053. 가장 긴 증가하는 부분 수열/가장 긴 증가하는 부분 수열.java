import java.util.Scanner;

public class Main {

    static int[] seq;
    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;
        int size = sc.nextInt();

        seq = new int[size];
        dp = new Integer[size];

        for (i = 0 ; i < size ; i ++) {
            seq[i] = sc.nextInt();
        }

        int max = 0;

        // dp 중에 가장 큰 값 구하기
        for (i = 0 ; i < size ; i ++) {
            max = Math.max(max, LIS(i));
        }

        System.out.println(max);
    }

    private static int LIS(int n) {
        // 만약 dp[n]에 아무 값도 없다면? (무조건 자기 자신은 포함되므로 1은 보장)
        if (dp[n] == null) {
            dp[n] = 1;

            for(int i = 0 ; i < n ; i ++ ) {

                // 만약 배열[n]보다 작은 값이 나온다면?
                if (seq[i] < seq[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }

        return dp[n];
    }
}