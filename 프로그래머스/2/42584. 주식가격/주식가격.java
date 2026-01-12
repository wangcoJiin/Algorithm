import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        stack.push(0);

        for (int i = 1 ; i < prices.length ; i ++ ) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.peek();
                answer[j] = i - j;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int l = prices.length - stack.peek();
            answer[stack.peek()] = l - 1;
            stack.pop();

        }
        
        return answer;
    }
}