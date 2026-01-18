import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        int first = 0;

        for (int i = 0 ; i < progresses.length ; i ++) {
            // 완료까지 남은 일수 넣기
            int remain = (100 - progresses[i]) / speeds[i];
            if (((100 - progresses[i]) % speeds[i]) == 0) {
                queue.add(remain);
            }
            else {
                queue.add(remain + 1);
            }
        }

        while(!queue.isEmpty()) {
            int count = 0;
            while (!queue.isEmpty() && queue.peek() <= first) {
                queue.poll();
                count ++;
            }
            if (count != 0 ){
                answer.add(count);
            }

            if (!queue.isEmpty()) {
                first = queue.peek();
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}