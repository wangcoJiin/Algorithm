import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();

        // 중심 이동 (5, 5)
        int x = 5;
        int y = 5;

        int nx = 0;
        int ny = 0;

        int i = 0;

        while (i < dirs.length()) {

            // 올라갈 때
            if (dirs.charAt(i) == 'U') {
                if (!isOver(x, y, 0, 1)) {
                    nx = x;
                    ny = y + 1;

                    // set에 들어갈 문장1: x y nx ny
                    // set에 들어갈 문장2: nx ny x y
                    set.add(x + " " + y + " " + nx + " " + ny);
                    set.add(nx + " " + ny + " " + x + " " + y);

                    y += 1;
                }
                i ++;
            }
            // 내려갈 때
            else if (dirs.charAt(i) == 'D') {
                if (!isOver(x, y, 0, -1)) {
                    nx = x;
                    ny = y - 1;

                    set.add(x + " " + y + " " + nx + " " + ny);
                    set.add(nx + " " + ny + " " + x + " " + y);

                    y -= 1;
                }
                i ++;
            }
            // 왼쪽으로 갈 때
            else if (dirs.charAt(i) == 'L') {
                if (!isOver(x, y, -1, 0)) {
                    nx = x - 1;
                    ny = y;

                    set.add(x + " " + y + " " + nx + " " + ny);
                    set.add(nx + " " + ny + " " + x + " " + y);

                    x -= 1;
                }
                i ++;
            }
            // 오른쪽으로 갈 때
            else if (dirs.charAt(i) == 'R') {
                if (!isOver(x, y, 1, 0)) {
                    nx = x + 1;
                    ny = y;

                    set.add(x + " " + y + " " + nx + " " + ny);
                    set.add(nx + " " + ny + " " + x + " " + y);

                    x += 1;
                }
                i ++;
            }
        }

        return set.size() / 2;

    }

    // 좌표 초과하는지 여부
    public static boolean isOver(int x, int y, int a, int b) {
        // x, y는 현재 좌표
        // a, b는 각각 x좌표로 이동하는 거리, y좌표로 이동하는 거리
        boolean over = false;

        if ((x + a) < 0 | (x + a) > 10) {
            over = true;
        }

        else if ((y + b) < 0 | (y + b) > 10) {
            over = true;
        }

        return over;
    }
}