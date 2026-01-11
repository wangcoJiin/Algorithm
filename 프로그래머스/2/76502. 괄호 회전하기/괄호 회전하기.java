import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        // 문자열 저장
        char[] string = s.toCharArray();
        int i = 0;
        int j = 0;

        // 문자열 회전
        while(i < s.length()) {
            stack.clear();
            boolean isok = true;

            if (j != 0) {
                char temp = string[0];
                for (j = 1 ; j < s.length() ; j ++) {
                    string[j - 1] = string[j];
                }
                string[s.length() - 1] = temp;

                // 스택으로 관리
                for (int k = 0 ; k < s.length() ; k ++ ) {
                    // 열린 괄호인 경우
                    if (string[k] == '(' | string[k] == '{' | string[k] == '[') {
                        stack.push(string[k]);
                    }
                    // 닫힌 괄호인 경우
                    else {
                        if (stack.isEmpty()) {
                            isok = false;
                            break;
                        }
                        else if (string[k] == ')') {
                            if (stack.peek() == '(') {
                                stack.pop();
                            }
                            else {
                                isok = false;
                                break;
                            }
                        }
                        else if (string[k] == '}') {
                            if (stack.peek() == '{') {
                                stack.pop();
                            }
                            else {
                                isok = false;
                                break;
                            }
                        }
                        else if (string[k] == ']') {
                            if (stack.peek() == '[') {
                                stack.pop();
                            }
                            else {
                                isok = false;
                                break;
                            }
                        }
                    }
                }
                if (isok && stack.isEmpty()) {
                    answer++;
                }

            }
            else {
                // 스택으로 관리
                for (int k = 0 ; k < s.length() ; k ++ ) {
                    // 열린 괄호인 경우
                    if (string[k] == '(' | string[k] == '{' | string[k] == '[') {
                        stack.push(string[k]);
                    }
                    // 닫힌 괄호인 경우
                    else {
                        if (stack.isEmpty()) {
                            isok = false;
                            break;
                        }
                        else if (string[k] == ')') {
                            if (stack.peek() == '(') {
                                stack.pop();
                            }
                            else {
                                isok = false;
                                break;
                            }
                        }
                        else if (string[k] == '}') {
                            if (stack.peek() == '{') {
                                stack.pop();
                            }
                            else {
                                isok = false;
                                break;
                            }
                        }
                        else if (string[k] == ']') {
                            if (stack.peek() == '[') {
                                stack.pop();
                            }
                            else {
                                isok = false;
                                break;
                            }
                        }
                    }
                }
                if (isok && stack.isEmpty()) {
                    answer++;
                }
                j ++;
            }

            i ++;
        }

        return answer;
    }
}