import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 10;
        int[] inputArr = new int[size];
        int sum = 0;

        for (int i = 0 ; i < size ; i ++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0 ; i < size ; i ++) {
            int current = sum + inputArr[i];

            // 100과의 거리가 같으면 더 큰 수 선택
            if (Math.abs(100 - sum) == Math.abs(100 - current)) {
                sum = current;
            }

            // 절대값으로 비교
            if (Math.abs(100 - sum) > Math.abs(100 - current)) {
                sum += inputArr[i];
            }
            else {
                break;
            }
        }

        bw.write(Integer.toString(sum));
        bw.close();
    }
}
