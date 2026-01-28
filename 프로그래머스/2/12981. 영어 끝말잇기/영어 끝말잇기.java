import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];
        int[] count = new int[n + 1];

        for (int i = 1 ; i < words.length + 1 ; i ++) {
            // 현재 누구
            int who = (i % n == 0) ? n : i % n;
            
            // 몇 번째?
            count[who] = count[who] + 1;
            
             if (i > 1) {
                 // set 사이즈
                 int setS = set.size();
                 if (words[i - 2].charAt(words[i - 2].length() - 1) == words[i - 1].charAt(0)) {
                     set.add(words[i - 1]);
                     if (set.size() == setS) {
                         // 중복단어
                         answer[0] = who;
                         answer[1] = count[who];
                         return answer;
                     }
                 }
                 else {
                     // 첫단어랑 끝단어 불일치
                     answer[0] = who;
                     answer[1] = count[who];
                     return answer;
                 }
                
             }
             else {
                 if (words[i - 1].length() == 1) {
                     answer[0] = who;
                     answer[1] = count[who];
                     return answer;
                 }
                 else {
                     set.add(words[i - 1]);
                 }
             }
        }
        

        return answer;
    }
}