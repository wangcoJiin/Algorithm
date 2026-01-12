import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        // 입력 문자열을 char 배열로
        char[] string = s.toCharArray();

        // 배열을 순회하며 stack 처리
        for (int i = 0 ; i < string.length ; i ++) {
            if (stack.isEmpty()) {
                stack.push(string[i]);
            }
            else {
                // 짝지어 지면 pop
                if (stack.peek() == string[i]) {
                    stack.pop();
                }
                // 짝 안 지어지면 push
                else {
                    stack.push(string[i]);
                }
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        System.out.println(stack);

        return answer;
    }
}