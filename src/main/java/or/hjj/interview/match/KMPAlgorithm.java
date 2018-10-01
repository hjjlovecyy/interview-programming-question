package or.hjj.interview.match;

import java.util.Scanner;

/**
 * Created by hejiajun
 * On 2018/10/1
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine(); // BBC ABCDAB ABCDABCDABDE
        String pattern = scanner.nextLine();    // ABCDABD

        int result = indexOf(source, pattern);
        System.out.println(result);
    }

    public static int indexOf(String source, String pattern) {
        int sLen = source.length();
        int pLen = pattern.length();
        int i = 0;
        int j = 0;

        int[] next = createNext(pattern);

        while (i < sLen && j < pLen) {
            if (j == -1 || source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }

        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    // ABCDABD -> next[-1, 0, 0, 0, 0, 1, 2]
    public static int[] createNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int pLen = pattern.length();
        int k = -1;
        int j = 0;

        while (j < pLen - 1) {
            if (-1 == k || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else
                // 利用了 next 数组的特性进行回溯，因为是由对称性的。
                k = next[k];
        }

        return next;
    }
}
