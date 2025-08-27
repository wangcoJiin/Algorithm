import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 백준 1920번 "수 찾기"
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> inputList = new ArrayList<>();

        // 첫 번째 배열
        int inputSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < inputSize ; i ++) {
            inputList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(inputList);

        // 비교할 입력
        int compareSize = Integer.parseInt(br.readLine());
        StringTokenizer compareInt = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < compareSize ; i ++) {
            int compare = Integer.parseInt(compareInt.nextToken());
            int r = search(compare, inputList);
            System.out.println(r);
        }
    }

    static int search(int number, List<Integer> list) {
        int L = 0;
        int R = list.size() - 1;

        while (L <= R) {
            int key = (L + R) / 2;

            if (number == list.get(key)) {
                return 1;
            }
            // 찾으려는 수가 중간보다 오른쪽에 있는 경우
            else if (number > list.get(key)) {
                L = key + 1;
            }
            // 찾으려는 수가 중간보다 왼쪽에 있는 경우
            else if (number < list.get(key)) {
                R = key - 1;
            }
        }
        return 0;
    }
}