import java.util.Scanner;

public class Main {
    static int[] soldiers;
    static Integer[] length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;
        int count = sc.nextInt();

        soldiers = new int[count];
        length = new Integer[count];

        for (i = 0 ; i < count ; i ++) {
            soldiers[i] = sc.nextInt();
        }

        // 가장 긴 배열 길이?
        int max = 0;
        for (i = 0 ; i < count ; i ++) {
            max = Math.max(max, HowPlace(i));
        }

        System.out.println(count - max);


    }

    private static int HowPlace(int n) {

        if (length[n] == null) {
            length[n] = 1;

            for (int i = 0 ; i < n ; i ++) {
                // 앞에가 더 크면?
                if (soldiers[i] > soldiers[n]) {
                    length[n] = Math.max(length[n], HowPlace(i) + 1);
                }
            }
        }

        return length[n];
    }

}