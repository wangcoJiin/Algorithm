import java.util.*;

class Solution {
    
    static int[] root;
    
    private static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        
        return root[x] = find(root[x]);
    }
    
    private static void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        
        if (rootx > rooty) {
            root[rootx] = rooty;
        }
        else {
            root[rooty] = rootx;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 비용 오름차순
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // 루트 초기화
        root = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            root[i] = i;
        }
        
        // 연결된 다리 개수
        int edges = 0;
        
        // 다리 건설
        for (int edge[] : costs) {
            // 다 연결된 경우
            if (edges == n - 1) {
                break;
            }
            
            // 두 섬이 연결되어 있는지? (루트가 똑같은지?)
            if (find(edge[0]) != find(edge[1])) {
                
                // 연결 안 되어 있으면 연결 (합치기)
                union(edge[0], edge[1]);
                
                // 건설 비용 추가
                answer += edge[2];
                
                // 다리 개수 증가
                edges ++;
            }
            
        }
        
        return answer;
    }
}