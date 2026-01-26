import java.util.*;

class Solution {
    
    // 관계 해시맵
    static HashMap<String, String> rela = new HashMap<>();
    // 이익 맵
    static HashMap<String, Integer> result = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        rela.clear();
        result.clear();
        
        List<Integer> answer = new ArrayList<>();

        // 관계 해시맵 데이터 설정
        for (int i = 0 ; i < enroll.length ; i ++) {
            if (!referral[i].equals("-")) {
                rela.put(enroll[i], referral[i]);
            }
        }

        // result 초기화
        for (String name : enroll) {
            result.put(name, 0);
        }

        for (int i = 0 ; i < seller.length ; i ++) {
            calcu(seller[i], amount[i] * 100);
        }
        
        for (int i = 0 ; i < enroll.length ; i ++) {
            answer.add(result.get(enroll[i]));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void calcu(String name, int money) {
        // name을 key로 가지는 rela 맵 탐색
        // 입력으로 받은 돈을 내가 가질 것, 나눠줄 것으로 분배
        // 만약 name을 key로 가지는 rela 값이 없다면 종료

        if (money == 0) {
            return;
        }
        
        // 줄 돈
        int give = money / 10;
        // 가질 돈
        int have = money - give;

        // 내 수익
        if (!result.containsKey(name)) {
            result.put(name, have);
        }
        else {
            result.put(name, result.get(name) + have);
        }

        // 추천인 없으면 중단
        if (!rela.containsKey(name)) {
            return;
        }

        calcu(rela.get(name), give);
    }
}
