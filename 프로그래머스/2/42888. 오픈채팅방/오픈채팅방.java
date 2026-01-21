import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        // 아이디:닉네임 형태의 해시맵
        HashMap<String, String> userMap = new HashMap<>();

        // 기록에서 아이디, 닉네임 추출하면서 맵에 저장
        for(String s : record) {
            String[] sen = s.split(" ");
            if (sen[0].equals("Enter")) {
                userMap.put(sen[1], sen[2]);
            }

            if (sen[0].equals("Change")) {
                if (userMap.containsKey(sen[1])) {
                    userMap.put(sen[1], sen[2]);
                }
            }
        }

        // 최종 문장
        for(String s : record) {
            StringBuilder sb = new StringBuilder();
            String[] sen = s.split(" ");

            if (sen[0].equals("Enter")) {
                sb.append(userMap.get(sen[1])).append("님이 ").append("들어왔습니다.");
                list.add(sb.toString());
            }
            if (sen[0].equals("Leave")) {
                sb.append(userMap.get(sen[1])).append("님이 ").append("나갔습니다.");
                list.add(sb.toString());
            }
        }
        
        return list.toArray(new String[0]);
    }
}