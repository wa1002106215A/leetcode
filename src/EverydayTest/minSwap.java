package EverydayTest;

import static java.lang.Math.min;

/**我们有两个长度相等且不为空的整型数组nums1和nums2。在一次操作中，我们可以交换nums1[i]和nums2[i]的元素。

        例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
        返回 使 nums1 和 nums2 严格递增所需操作的最小次数 。

        数组arr严格递增 且arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]。
*/
public class minSwap {
    public static int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
                }
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums1={1,3,5,4};
        int[] nums2={1,2,3,7};
        System.out.println(minSwap(nums1,nums2));
    }
}
