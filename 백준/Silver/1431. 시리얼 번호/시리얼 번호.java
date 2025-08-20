import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i;
        int j;

        List<String> input = new ArrayList<>();

        for (i = 0 ; i < n ; i ++ ) {
            input.add(sc.next());
        }

        // 1. 길이로 정렬
        input.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            else {
                // 3. 사전순 비교
                if (sumInt(a) == sumInt(b)) {
                    return a.compareTo(b);
                }

                // 2. 길이 같으면 숫자 합 비교
                return sumInt(a) - sumInt(b);
            }
        });

        for (j = 0 ; j < input.size() ; j ++ ) {
            System.out.println(input.get(j));
        }
    }

    private static int sumInt(String word) {
        char[] wordChar = word.toCharArray();
        int k;
        String total = "";
        int result = 0;

        for (k = 0 ; k < word.length(); k ++ ){
            if ('0' <= wordChar[k] && wordChar[k] <= '9') {
                result += (int) wordChar[k];
                result -= '0';
            }
        }

        return result;
    }
}