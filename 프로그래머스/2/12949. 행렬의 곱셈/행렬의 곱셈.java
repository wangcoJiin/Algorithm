class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr1의 행 개수
        int row1 = arr1.length;
        // arr1의 열 개수
        int co1 = arr1[row1 - 1].length;

        // arr2의 행 개수
        int row2 = arr2.length;
        // arr2의 열 개수
        int co2 = arr2[row2 - 1].length;

        int[][] answer = new int[row1][co2];

        // 곱하기 반복문
        for (int i = 0 ; i < row1 ; i ++) {
            for (int j = 0 ; j < co1 ; j ++) {
                int sum = 0;
                for (int k = 0 ; k < co2 ; k ++ ){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }
}