import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] string = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        for (char ch : string) {
            if (ch == '(') {
                charStack.push(ch);
            }
            if (ch == ')') {
                if (!charStack.isEmpty()) {
                    charStack.pop();
                }
                else {
                    answer = false;
                }
            }
        }

        if (!charStack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}