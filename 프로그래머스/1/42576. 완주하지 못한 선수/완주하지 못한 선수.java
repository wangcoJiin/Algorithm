import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        String answer = "";
        
        for (String p : participant) {
            if(hashMap.containsKey(p)) {
                hashMap.put(p, hashMap.get(p) + 1);
            }
            else {
                hashMap.put(p, 1);
            }
        }
        
        for (String c : completion) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) - 1);
            }
        }
        
        for (String k : hashMap.keySet()) {
            if (hashMap.get(k) == 1) {
                answer = k;
            }
        }
        
        return answer;
    }
}