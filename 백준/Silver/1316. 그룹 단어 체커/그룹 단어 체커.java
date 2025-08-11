import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int count;

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int i;

        int inputCount = sc.nextInt();
        for (i = 0 ; i < inputCount ; i ++){
            String str = sc.next();
            boolean bool = isGroupWord(str);

            if (bool) {
                count ++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String inputString) {
        int k;
        int j;

        char[] arr = inputString.toCharArray();

        if (arr.length < 3){
            return true;
        }

        if (arr[0] == arr[arr.length -1]){
            if (inputString.split(String.valueOf(arr[0])).length == 0) {
                return true;
            }
            return false;
        }

        for (k = 0 ; k < arr.length ; k ++) {
            List<Integer> index = new ArrayList<>();
            int t = 0;
            char test = arr[k];
            for (j = 0 ; j < arr.length ; j ++) {
                if (test == arr[j]) {
                    index.add(j);
                    if(index.size() > 1 && (index.get(t) - index.get(t-1)) != 1) {
                        return false;
                    }
                    t ++;
                }
            }
        }
        return true;
    }
}
