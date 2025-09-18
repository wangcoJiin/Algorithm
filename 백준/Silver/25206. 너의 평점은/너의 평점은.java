import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Float> list = new ArrayList<>();
        float creditSum = 0;
        float sum = 0;

        for (int i = 0 ; i < 20 ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            float credit = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            float gradeScore = 0.0F;

            switch (grade) {
                case "A+": gradeScore = 4.5F;
                    break;
                case "A0": gradeScore = 4.0F;
                    break;
                case "B+": gradeScore = 3.5F;
                    break;
                case "B0": gradeScore = 3.0F;
                    break;
                case "C+": gradeScore = 2.5F;
                    break;
                case "C0": gradeScore = 2.0F;
                    break;
                case "D+": gradeScore = 1.5F;
                    break;
                case "D0": gradeScore = 1.0F;
                    break;
                case "F": gradeScore = 0.0F;
                    break;
                case "P":
                    continue;
            }

            float subjectGrade = credit * gradeScore;
            creditSum += credit;

            list.add(subjectGrade);
        }

        for (float num : list) {
            sum += num / creditSum;
        }

        System.out.print(sum);
    }
}
