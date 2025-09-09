import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세로로 몇 칸 인지?
        int cageCount = Integer.parseInt(br.readLine());

        // 사자 우리
        int[] cage1 = new int[3]; // 이전 행 (아무것도 안 넣음, 왼쪽에 넣음, 오른쪽에 넣음 -> 한 행에 3가지 경우 존재)

        // 사자끼리 대각선 이상으로 배치해야함 (아예 배치 안 하는 경우도 허용 (경우의 수 1은 무조건 추가))
        for (int i = 1 ; i <= cageCount ; i ++) {
            int[] cage2 = new int[3]; // 이후 행

            if (i == 1) {
                // n이 1 들어오는 경우 모든 경우 하나씩 가능 (아예 안 넣거나, 왼쪽에 넣거나, 오른쪽에 넣거나)
                cage1[0] = 1;
                cage1[1] = 1;
                cage1[2] = 1;
            }
            else{
                // 아무것도 안 넣는 경우, 위에 어떤 경우가 오든 상관 없음
                cage2[0] = (cage1[0] + cage1[1] + cage1[2]) % 9901;

                // 왼쪽에 넣는 경우, 위에는 아무것도 없거나 오른쪽만 있어야 함
                cage2[1] = (cage1[0] + cage1[2]) % 9901;

                // 오른쪽에 넣는 경우
                cage2[2] = (cage1[0] + cage1[1]) % 9901;

                // 현재 행을 이전 행으로
                cage1 = cage2;
            }
        }

        // 모든 경우의 수
        System.out.println((cage1[0] + cage1[1] + cage1[2]) % 9901);
    }

}
