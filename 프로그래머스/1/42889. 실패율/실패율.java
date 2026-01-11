import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) {
                // 유저 수
        int users = stages.length;

        // 각 스테이지 멈춰있는 유저 수
        int[] stageUsers = new int[N + 2];
        for (int j = 1 ; j < stages.length + 1 ; j ++) {
            if (stages[j - 1] <= N+1) {
                stageUsers[stages[j- 1]] += 1;
            }
        }

        // 실패율
        HashMap<Integer, Double> failure = new HashMap<>();

        for (int i = 1 ; i < N + 1 ; i ++) {
                        // 스테이지에 도달한 사람 없으면 실패율 0
            if (stageUsers[i] == 0) {
                failure.put(i, 0.0);
            }
            else {
                failure.put(i, (double) stageUsers[i] / users);
                users -= stageUsers[i];
            }
        }
        
        // map에서 value를 기준으로 내림차순 한 뒤 key 값만 int 배열로 변환해야함.

        return failure.entrySet().stream().sorted((o1, o2) ->
                o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) : Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey).toArray();
    }
}