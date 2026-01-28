import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> count = new ArrayList<>();
        
        // 귤 크기:개수
        for (int i : tangerine) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        
        // 개수만 뽑기
        for (int c : map.values()) {
            count.add(c);
        }
        
        // 개수 내림차순 정렬
        count.sort(Collections.reverseOrder());
        
        int sum = 0;
        int tan = 0;

        for (int c : count) {
            // 크기별 개수 순차적으로 더함
            sum += c;
            
            // 크기 종류도 더하기
            tan++;

            if (sum >= k) {
                break;
            }
        }

        return tan;
    }
}