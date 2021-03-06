import org.junit.Test;

/**
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 * <p>
 * 例如，数组[2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 * <p>
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 * <p>
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3]
 * 输出：6
 * 解释：[1,3] 共有 4 个子集：
 * - 空子集的异或总和是 0 。
 * - [1] 的异或总和为 1 。
 * - [3] 的异或总和为 3 。
 * - [1,3] 的异或总和为 1 XOR 3 = 2 。
 * 0 + 1 + 3 + 2 = 6
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,6]
 * 输出：28
 * 解释：[5,1,6] 共有 8 个子集：
 * - 空子集的异或总和是 0 。
 * - [5] 的异或总和为 5 。
 * - [1] 的异或总和为 1 。
 * - [6] 的异或总和为 6 。
 * - [5,1] 的异或总和为 5 XOR 1 = 4 。
 * - [5,6] 的异或总和为 5 XOR 6 = 3 。
 * - [1,6] 的异或总和为 1 XOR 6 = 7 。
 * - [5,1,6] 的异或总和为 5 XOR 1 XOR 6 = 2 。
 * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
 * 示例 3：
 * <p>
 * 输入：nums = [3,4,5,6,7,8]
 * 输出：480
 * 解释：每个子集的全部异或总和值之和为 480 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 12
 * 1 <= nums[i] <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 05-16-2021 14:15
 */
public class SubsetXORSum5739 {

    public int subsetXORSum2(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                int tmp = i >> j & 1;
                // 判断是否为奇数
                if (tmp == 1) {
                    temp ^= nums[j];
                }
            }
            res += temp;
        }
        return res;
    }

    int res = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return res;
    }


    private void dfs(int[] nums, int begin, int tmp) {
        res += tmp;
        for (int i = begin; i < nums.length; i++) {
            tmp = tmp ^ nums[i];
            dfs(nums, i + 1, tmp);
            tmp = tmp ^ nums[i];
        }
    }

    @Test
    public void subsetXORSumTest() {
        int[] nums = {1, 3};
        System.out.println(subsetXORSum(nums));
        System.out.println(subsetXORSum2(nums));
    }

}
