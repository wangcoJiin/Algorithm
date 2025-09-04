import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        // 어떤 사람 A와 B의 겹지인을 통해 A가 B와 연결될 수 있는 최단루트 찾기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 유저의 수 n, 친구 관계의 수 m
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 사람
        int a;
        int b;

        arr = new ArrayList[n + 1];

        // 각 원소에 달릴 리스트 추가하기
        for (int i = 1 ; i <= n ; i ++) {
            arr[i] = new ArrayList<>();
        }

        // 중복 들어오니까 중복 여부 확인하는 변수
        boolean[][] isSeen = new boolean[n + 1][n + 1];

        // 입력으로 들어오는 값을 적절히 삽입
        for (int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 처음 들어오는 짝이면
            if (!isSeen[a][b]) {
                // 확인 처리 하고
                isSeen[a][b] = true;
                isSeen[b][a] = true;

                // 1 3 / 2 3이 입력으로 들어오면
                // arr[1] = [3]
                // arr[2] = [3]
                // arr[3] = [1, 2]
                // 이런식으로 저장되게끔 함
                arr[a].add(b);
                arr[b].add(a);
            }
        }

        int baconMin = 6000;
        int minUser = 0;

        // 각 사람별 케빈 베이컨 개수 구하기
        for (int i = 1 ; i <= n ; i ++) {
            int baconSum = bacon(i);
            if (baconMin > baconSum) {
                baconMin = baconSum;
                minUser = i;
            }
            // 여러 명일 경우에는 번호가 가장 작은 사람 출력
            if (baconMin == baconSum) {
                if (minUser > i) {
                    minUser = i;
                }
            }
        }

        System.out.println(minUser);

    }

    // bfs 쓰기 (s에서 시작해서 모든 최단거리 합 계산)
    static int bacon(int t) {
        // 각 사람까지의 최단 거리 배열
        int[] minD = new int[n + 1];

        // 방문했는지?
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<Integer>();

        // 큐에 탐색 시작 번호 삽입
        q.add(t);

        // 시작 점을 방문 처리
        visited[t] = true;
        minD[t] = 0;

        while (!q.isEmpty()) {
            int k = q.poll();
            for(int i = 0 ; i < arr[k].size() ; i ++) {

                int next = arr[k].get(i);
                // 내가 친해져야 하는 사람의 이웃을 방문하지 않았다면
                if (!visited[next]) {
                    visited[next] = true;
                    minD[next] = minD[k] + 1;
                    q.add(next);
                }
            }
        }

        // 최단 거리 합
        int sum = 0;
        for(int i = 0 ; i <= n ; i ++) {
            sum = sum + minD[i];
        }

        return sum;
    }
}