import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int books = sc.nextInt();
        int i;
        int j;
        int count;
        List<String> arr = new ArrayList<>();
        List<Integer> countArr = new ArrayList<>();
        List<String> bestSeller = new ArrayList<>();

        for (i = 0 ; i < books ; i ++) {
            count = 0;
            arr.add(sc.next());

            for (j = 0 ; j <= i ; j ++) {
                if (arr.get(i).equals(arr.get(j))){
                    count ++;
                    countArr.add(i, count);
                }
            }
        }

        int maxCount = Collections.max(countArr);

        for (i = 0 ; i < books ; i ++ ) {
            if (countArr.get(i) == maxCount) {
                bestSeller.add(arr.get(i));
            }
        }

        Collections.sort(bestSeller);
        System.out.println(bestSeller.get(0));

    }

}
