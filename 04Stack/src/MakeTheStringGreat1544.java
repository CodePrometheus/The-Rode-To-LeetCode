import org.junit.Test;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode"
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 *
 * @Author: zzStar
 * @Date: 02-22-2021 12:42
 */
public class MakeTheStringGreat1544 {

    public String makeGood(String s) {
        // 模拟栈
        int top = -1;
        char[] stack = new char[s.length()];
        // 遍历索引
        char ch;
        int index = 0;
        while (index < s.length()) {
            ch = s.charAt(index++);

            if (top != -1) {
                if (ch - 32 == stack[top] || ch + 32 == stack[top]) {
                    // 不断比较
                    top--;
                    continue;
                }
            }
            stack[++top] = ch;
        }
        return new String(stack, 0, top + 1);
    }

    @Test
    public void makeGoodTest() {
        String s = "abBAcC";
        System.out.println(makeGood(s));
    }
}
