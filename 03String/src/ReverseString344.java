import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 02-17-2021 23:38
 */
public class ReverseString344 {

    /**
     * 双指针
     * 对于长度为 N 的待被反转的字符数组，我们可以观察反转前后下标的变化，假设反转前字符数组为 s[0] s[1] s[2] ... s[N - 1]，那么反转后字符数组为 s[N - 1] s[N - 2] ... s[0]。比较反转前后下标变化很容易得出 s[i] 的字符与 s[N - 1 - i] 的字符发生了交换的规律，因此我们可以得出如下双指针的解法：
     *
     * 将 left 指向字符数组首元素，right 指向字符数组尾元素。
     * 当 left < right：
     * 交换 s[left] 和 s[right]；
     * left 指针右移一位，即 left = left + 1；
     * right 指针左移一位，即 right = right - 1。
     * 当 left >= right，反转结束，返回字符数组即可
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    @Test
    public void reverseStringTest() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
    }
}
