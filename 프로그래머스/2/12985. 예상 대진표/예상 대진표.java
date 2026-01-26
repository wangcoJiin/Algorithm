import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        int nextA = a;
        int nextB = b;
        int count = 0;
        
        // 왼쪽 사람이 N-1번 사람이고 오른쪽 사람이 N번 사람일 때, 
        // 승리 시 부여받는 번호는 + 1 / 2한 값이다.
        
        while (count < n / 2) {
            if (nextA == nextB) {
                break;
            }
            else {
                nextA = (nextA + 1) / 2;
                nextB = (nextB + 1) / 2;
                
                answer ++;
            }
            
            count ++;
        }

        return answer;
    }
}