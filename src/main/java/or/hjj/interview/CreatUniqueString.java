package or.hjj.interview;

/**
 * 使用 1-9，a-z，A-Z，生成不重复的长度为4的 ID（Sring），
 * 写两个方法一个获取不重复的 ID，一个获取生成 ID 的总数。
 *
 * 一种顺序生成，一种随机生成（生成函数里面递归）
 *
 * 思路：总共可以生产 62*62*62*62，所以本题可以采用求摸运算
 */
public class CreatUniqueString {
    // 生产的次数
    private int generateNum = 0;
    // 10 + 26 + 26
    private final static int TOTALCHARNUM = 62;

    public static void main(String[] args) {
        CreatUniqueString creatUniqueString = new CreatUniqueString();
        for (int i = 0; i < 100; i++) {
            System.out.println(creatUniqueString.generator());
        }

        System.out.println(creatUniqueString.getTotal());
    }

    public String generator() {
        // 每一位的求摸结果，从右到左
        int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
        // 每一位的字符
        char c1 = '0', c2 = '0', c3 = '0', c4 = '0';
        int temp = generateNum;

        // 得到 i1-i4
        i1 = temp % TOTALCHARNUM;
        temp /= TOTALCHARNUM;
        if (TOTALCHARNUM > temp) {
            i2 = temp % TOTALCHARNUM;
            temp /= TOTALCHARNUM;
            if (TOTALCHARNUM > temp) {
                i3 = temp % TOTALCHARNUM;
                temp /= TOTALCHARNUM;
                if (TOTALCHARNUM > temp) {
                    i4 = temp % TOTALCHARNUM;
                }
            }
        }

        // 根据 i1-i4 得到 c1-c4
        c1 = intToChar(i1, c1);
        c2 = intToChar(i2, c2);
        c3 = intToChar(i3, c3);
        c4 = intToChar(i4, c4);

        generateNum++;

        return "" + c4 + c3 + c2 + c1;
    }

    public int getTotal() {
        return generateNum;
    }

    // 根据 interget 得到 char
    private char intToChar(int i, char c) {
        if (9 < i) {
            if (35 < i)
                c = (char)(c - '0' + 'A' + i - 36);
            else
                c = (char)(c - '0' + 'a' + i - 10);
        } else
            c = (char)(c + i);

        return c;
    }
}
