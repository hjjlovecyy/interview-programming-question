package or.hjj.interview;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 现有 n 个物品，每个物品有三个参数 ai，bi，ci，定义 i 物品不合格品的依据是：
 * 若存在 j 物品（它的参数为 aj，bj，cj），使得 aj>ai，bj>bi，cj>ci，则
 * i 物品为不及格。
 */
public class TestQualifiedGood {
    private static int notQualifiedNum = 0;

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        // 临时存放当前输入字符串
        StringBuffer buffer = new StringBuffer();
        // 存放所有输入字符串
        List<String> inputStr = new ArrayList<>();
        String presentStr = "";
        int inputNum = 0;
        int ch = 0;

        while (true) {
            ch = input.read();
            // 回车跳出本次循环
            if ('\r' == ch)
                continue;
            // 换行表示当前字符串读入结束
            if ('\n' == ch) {
                presentStr = buffer.toString().trim();
                // 读取第一行输入总数
                if (1 == strToIntArray(presentStr).length) {
                    inputNum = strToIntArray(presentStr)[0];
                    buffer.delete(0, buffer.length());
                    continue;
                }

                inputStr.add(presentStr);
                buffer.delete(0, buffer.length());
                // 输入完成，跳出循环
                if (inputStr.size() == inputNum) {
                    break;
                }
                // '\n'不存入字符串
                continue;
            }

            buffer.append((char)ch);
        }
        judgeNotQualifiedNum(inputStr);
        System.out.println("不及格数量：" + notQualifiedNum);
    }

    /**
     * 判断不及格的数量
     * @param list 总共的输入
     * @return
     */
    private static void judgeNotQualifiedNum(List<String> list) {
        int[] presentArray = null;
        int[] otherArray = null;
        
        for (String presentStr: list) {
            presentArray = strToIntArray(presentStr);
            
            for (String otherStr: list) {
                otherArray = strToIntArray(otherStr);
                // 若存在不及格就跳出当级循环
                if (presentArray[0] < otherArray[0] &&
                        presentArray[1] < otherArray[1] &&
                        presentArray[2] < otherArray[2]) {
                    notQualifiedNum++;
                    break;
                }
                
            }
        }
    }

    /**
     * 把字符串转换成 int 数组
     * @param str 源字符串
     * @return 源字符串转换成的 int 数组
     */
    private static int[] strToIntArray(String str) {
        int[] result = new int[3];
        String[] strArray = str.split(" ");
        if (1 == strArray.length) {
            result = new int[1];
            result[0] = Integer.parseInt(strArray[0]);
            return result;
        }

        for (int i = 0; i < strArray.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }

        return result;
    }
}
