import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(arr[0]);
        
        for (int i = 1 ; i < arr.length ; i ++) {
            // 연속된 숫자 아니면?
            if (arr[i] != stack.peek()) {
                stack.push(arr[i]);
            }
        }
        
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        
        Collections.reverse(list);
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        

        return answer;
    }
}