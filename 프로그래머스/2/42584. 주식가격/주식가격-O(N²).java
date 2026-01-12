/* O(N^2) 로 풀어보기 */
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // O(N^2) 로 풀어보기
        for (int i = 0 ; i < prices.length ; i ++) {
            int count = 0;
            for (int j = (i + 1) ; j < prices.length ; j ++ ) {
                if (prices[j] >= prices[i] && count == 0) {
                    answer[i] += 1;
                }
                else if (count == 0 && prices[j] < prices[i]) {
                    answer[i] += 1;
                    count ++;
                }
            }
        }

        return answer;
    }
}
