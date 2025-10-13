import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 4방향 이동 (북, 동, 남, 서) (0, 1, 2, 3)
        int[] findR = {-1, 0, 1, 0};;
        int[] findC = {0, 1, 0, -1};

        int count = 0;

        // n, m
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 현재 칸, 방향
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        // 입력받기
        for (int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // int 배열로...
            }
        }

        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (arr[r][c] == 0) {
                arr[r][c] = 2; // 청소하고 2로 변경 해주기
                count += 1;
            }

            // 현재 칸의 주변 4칸 중
            boolean hasDirty = false;
            for (int i = 0 ; i < 4; i ++) {
                int nextR = r + findR[i];
                int nextC = c + findC[i];

                // 배열 범위 고려
                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;

                if (arr[nextR][nextC] == 0) {
                    hasDirty = true;
                    break;
                }
            }

            // 청소되지 않은 빈 칸이 없는 경우
            if (!hasDirty) {
                // 뒤쪽
                int back = (d + 2) % 4;
                int backR = r + findR[back];
                int backC = c + findC[back];

                // 뒤가 벽이면?
                if (arr[backR][backC] == 1) {
                    break;
                }
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                r = backR;
                c = backC;
            }
            // 청소되지 않은 빈 칸이 있는 경우
            else {
                for (int i = 0; i < 4; i++) {
                    // 반시계 회전 (북 -> 서, 남 -> 동)
                    d = (d + 3) % 4;

                    int nextR = r + findR[d];
                    int nextC = c + findC[d];

                    // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                    if (arr[nextR][nextC] == 0) {
                        r = nextR;
                        c = nextC;
                        break;
                    }

                    // 1번으로 돌아간다.
                }
            }
        }

        System.out.println(count);
    }

}
