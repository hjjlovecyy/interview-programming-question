package or.hjj.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个已经降序排好的数组，将两个数组合并，合并后依然保持降序。
 */
public class TwoArrayMerge {
    public static void main(String[] args) {
        int[] A = {7, 4, 2};
        int[] B = {9, 6, 5, 1};

        for (int i: together(A, B)) {
            System.out.println(i);
        }
    }

    public static int[] together(int[] A,int[] B) {
        List<Integer> list = new ArrayList<>();

        for (int i: A) {
            list.add(i);
        }

        for (int j: B) {
            list.add(j);
        }

        return list.stream().sorted(((o1, o2) -> o2 - o1)).mapToInt(Integer::valueOf).toArray();
    }
}
