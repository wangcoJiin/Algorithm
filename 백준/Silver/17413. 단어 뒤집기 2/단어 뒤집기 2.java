import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(reverseProcess(input));
    }

    static String reverseProcess(String input) {
        String result = "";
        int i = 0;
        while (i < input.length()) {
            // <> 안이라면?
            if (input.charAt(i) == '<') {
                // 가장 가까운 '>' 위치
                int close = input.indexOf('>', i);

                // '>' 까지 단어 저장
                result += input.substring(i, close + 1);

                i = close + 1;
            }
            // 괄호 안이 아닌 경우 (역순으로 바꿔야 함)
            else {
                // 가까운 '<' 위치
                int nextOpen = input.indexOf('<', i);

                // 만약 '<' 없으면 -1로 됨
                if (nextOpen == -1) nextOpen = input.length();

                String outside = input.substring(i, nextOpen);

                result += reverse(outside);

                i = nextOpen;

            }
        }
        return result;
    }

    // 단어 뒤집기
    static String reverse(String str) {
        String[] word = str.split(" ", -1);
        String reverseStr = "";

        for (int i = 0; i <  word.length; i ++) {
            char[] arr = word[i].toCharArray();

            for (int j = arr.length - 1 ; j >= 0 ; j --) {
                reverseStr += arr[j];
            }
            // 마지막 단어가 아니면 공백 붙이기
            if (i != word.length - 1) {
                reverseStr += " ";
            }
        }
        return reverseStr;
    }
}
