package or.hjj.interview;

import java.util.*;

public class FindArraySubset {
    private static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] source = {3, 2, 7, 9};
        int target = 9;

        // sort the input array
        Arrays.sort(source);
        int[] tempSource = reduceArray(source, target);

        if (target < source[0]) {
            System.out.println("no subset exist!");
        } else {
            int cycNum = target / tempSource[0];

            for (int i = 1; i <= cycNum; i++) {
                int[] cache = new int[i];
                recursionFind(tempSource, target, cache, i, i);
            }

            result.forEach(System.out::println);
        }
    }

    /**
     * Because the source array has already sorted, but maybe
     * some value in the array are bigger than target, so we
     * should crop the array to ensure that no value is bigger
     * than target.
     * @param source source array.
     * @param target target value.
     * @return new array cropped from source whose value is
     * smaller than target.
     */
    public static int[] reduceArray(int[] source, int target) {
        int length = 0;

        if (source[source.length - 1] < target) {
            return source;
        }

        for (int i = 0; i < source.length; i++) {
            if (target < source[i]) {
                length = i;
                break;
            }
        }

        int[] newSource = new int[length];
        System.arraycopy(source, 0, newSource, 0, length);
        return newSource;
    }

    /**
     * Find the subset whose sum is equal to target.
     * @param source source array.
     * @param target target value.
     * @param cache cache array to save subset.
     * @param cycNum total cycle number, which means the number of recursion.
     * @param cycIdx cycle index. cycIdx-- after one recursion.
     */
    public static void recursionFind(int[] source, int target, int[] cache, int cycNum, int cycIdx) {
        int cacheIdx = cycNum - cycIdx;
        cycIdx--;
        for (int i = 0; i < source.length; i++) {
            cache[cacheIdx] = source[i];

            if (target == getSum(cache)) {
                listAdd(cache);
            } else if (target < getSum(cache)) {
                cache[cacheIdx] = 0;
                break;
            }

            if (1 <= cycIdx) {
                recursionFind(source, target, cache, cycNum, cycIdx);
            }
        }
    }

    /**
     * add cache array to result list(List<List<String>>),
     * skip the cache if the cache's value already exist in
     * list
     * @param cache cache array to save subset.
     */
    public static void listAdd(int[] cache) {
        List<Integer> list = new ArrayList<>();
        for (int i: cache) {
            if (0 == i) {
                continue;
            }
            list.add(i);
        }
        Collections.sort(list);
        Iterator<List<Integer>> iterator = result.iterator();
        while (iterator.hasNext()) {
            List<Integer> middleResult = iterator.next();
            if (list.size() == middleResult.size()) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(middleResult.get(i))) {
                        break;
                    }
                }
                return;
            }
        }
        result.add(list);
    }


    /**
     * @param cache cache array to save subset.
     * @return the sum of cache array.
     */
    public static int getSum(int[] cache) {
        int sum = 0;
        for (int i = 0; i < cache.length; i++) {
            sum += cache[i];
        }
        return sum;
    }
}
