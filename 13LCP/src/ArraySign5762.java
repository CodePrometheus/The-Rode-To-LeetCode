/**
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sign-of-the-product-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-11-2021 15:01
 */
public class ArraySign5762 {

    public int arraySign(int[] nums) {
        int num = 1;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            num = num * (n > 0 ? 1 : -1);
        }
        return num;
    }

    public int arraySign2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 统计负数的个数
            if (num < 0) {
                res++;
            } else if (num == 0) {
                return 0;
            }
        }
        // 奇偶 偶数,n&1返回0 否则返回1,为奇数
        return (res & 1) == 1 ? -1 : 1;
    }

}
