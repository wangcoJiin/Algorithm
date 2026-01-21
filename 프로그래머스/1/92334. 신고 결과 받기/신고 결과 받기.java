import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0 ; i < report.length ; i ++) {
            String[] split = report[i].split(" ");

            if (!map1.containsKey(split[1])) {
                map1.put(split[1], new HashSet<>());
            }

            HashSet<String> value = map1.get(split[1]);
            value.add(split[0]);

            map1.put(split[1], value);
        }

        for (String s : map1.keySet()) {
            if (map1.get(s).size() >= k) {
                HashSet<String> value = map1.get(s);

                for (String t : value) {
                    if (!map2.containsKey(t)) {
                        map2.put(t, 0);
                    }
                    int count = map2.get(t);
                    map2.put(t, count + 1);
                }
            }
        }

        for (int i = 0 ; i < id_list.length ; i ++) {
            if (map2.containsKey(id_list[i])) {
                answer[i] = map2.get(id_list[i]);
            }
        }

        return answer;
    }
}