import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<String> stack = new Stack<>();
        String[] string = s.split(" ");
        stack.push(string[0]);

        for (int i = 1 ; i < string.length ; i ++) {
            if (!stack.isEmpty() &&string[i].equals("Z")) {
                stack.pop();
            }
            else {
                stack.push(string[i]);
            }
        }

        while (!stack.isEmpty()) {
            answer += Integer.parseInt(stack.pop());
        }
        return answer;
    }
}