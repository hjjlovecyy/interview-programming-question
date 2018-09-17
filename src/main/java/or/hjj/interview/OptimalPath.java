package or.hjj.interview;

import java.util.Scanner;

public class OptimalPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next(); // abcd
        String dateNeedModify = scanner.next(); // acc

        System.out.println(modifyDate(date, dateNeedModify));
    }

    /**
     * This is the optimal path question. To calculate how much
     * step about one string changes to another. Only deletion and
     * addition are permitted.
     * @param date target string.
     * @param dateNeedModify source string.
     * @return how much step.
     */
    public static int modifyDate(String date, String dateNeedModify) {
        int result = 0;

        if (date.equals(dateNeedModify)) {
            return result;
        }

        int dateLength = date.length();
        int dateNLength = dateNeedModify.length();
        int length = Math.max(dateLength, dateNLength);

        int[][] resultArr = new int[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            resultArr[i][0] = i;
            resultArr[0][i] = i;
        }

        for (int i = 1; i <= dateLength; i++) {
            for (int j = 1; j <= dateNLength; j++) {
                if (date.charAt(i - 1) == dateNeedModify.charAt(j - 1)) {
                    resultArr[i][j] = resultArr[i - 1][j - 1];
                } else {
                    // only delete and add.
                    int min = Math.min(resultArr[i - 1][j] + 1, resultArr[i][j - 1] + 1);
                    resultArr[i][j] = min;
                }
            }
        }

        result = resultArr[dateLength][dateNLength];

        return result;
    }
}
