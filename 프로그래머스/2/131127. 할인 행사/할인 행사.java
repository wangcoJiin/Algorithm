import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> copyHashMap = new HashMap<>();

        int answer = 0;

        for (int i = 0 ; i < want.length ; i ++) {
            hashMap.put(want[i], number[i]);
        }

        // 첫 10일 할인품목
        for (int i = 0 ; i < 10 ; i ++) {
            if (hashMap.containsKey(discount[i])) {
                if (!copyHashMap.containsKey(discount[i])) {
                    copyHashMap.put(discount[i], 1);
                }
                else {
                    copyHashMap.put(discount[i], copyHashMap.get(discount[i]) + 1);
                }
            }
        }

        int c = 0;
        while(c + 9 < discount.length) {
            int t = 0;

            for (int i = 0 ; i < want.length ; i ++) {
                String item = want[i];
                int need = hashMap.get(item);
                int have = 0;
                if (copyHashMap.containsKey(item)) {
                    have = copyHashMap.get(item);
                }
                if (have == need) {
                    t ++;
                }
            }

            if (t == want.length) {
                answer ++;
            }

            // 1일 이동
            if (c + 10 < discount.length) {
                // 밀려서 없어지는 품목
                String out = discount[c];
                // 새로 추가되는 품목
                String in = discount[c + 10];

                if (hashMap.containsKey(out)) {
                    if (copyHashMap.containsKey(out)) {
                        copyHashMap.put(out, copyHashMap.get(out) - 1);

                        if (copyHashMap.get(out) == 0) {
                            copyHashMap.remove(out);
                        }
                    }
                }

                if (hashMap.containsKey(in)) {
                    if (copyHashMap.containsKey(in)) {
                        copyHashMap.put(in, copyHashMap.get(in) + 1);
                    }
                    else {
                        copyHashMap.put(in, 1);
                    }
                }
            }

            c ++;
        }

        return answer;
    }
}