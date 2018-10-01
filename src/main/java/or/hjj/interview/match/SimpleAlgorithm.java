package or.hjj.interview.match;

import java.util.Scanner;

/**
 * Created by hejiajun
 * On 2018/10/1
 */
public class SimpleAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine(); // BBC ABCDAB ABCDABCDABDE
        String pattern = scanner.nextLine();    // ABCDABD

        long startTime = System.currentTimeMillis();
        int result = indexOf(source, pattern);
        long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(result);
    }

    /**
     * The Simple Algorithm of String Matching.
     * @param source
     * @param pattern
     * @return if exist return start point else return -1
     */
    public static int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        int sLen = source.length(), pLen = pattern.length();
        char[] sChars = source.toCharArray();
        char[] pChars = pattern.toCharArray();

        while (i < sLen && j < pLen) {
            if (sChars[i] == pChars[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLen)
            return i - j;
        else
            return -1;
    }
}
