import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        
        List<Integer> arr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // 1번 수포자
        int[] num1 = {1, 2, 3, 4, 5};
        int result1 = 0;

        // 2번 수포자
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int result2 = 0;

        // 3번 수포자
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int result3 = 0;

        // 정답이랑 비교
        for (int i = 0 ; i < answers.length ; i ++ ) {

            int test1 = i % 5;
            if (num1[test1] == answers[i]) {
                result1 += 1;
            }

            int test2 = i % 8;
            if (num2[test2] == answers[i]) {
                result2 += 1;
            }

            int test3 = i % 10;
            if (num3[test3] == answers[i]) {
                result3 += 1;
            }
        }

        arr.add(result1);
        arr.add(result2);
        arr.add(result3);
        int max = Collections.max(arr);

        if (result1 == max) {
            result.add(1);
        }
        if (result2 == max) {
            result.add(2);
        }
        if (result3 == max) {
            result.add(3);
        }

       return result.stream().mapToInt(Integer::intValue).toArray();
    }
}