package EasyTest;

import java.util.Arrays;
import java.util.HashMap;

public class advantageCount {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Integer[] index = new Integer[nums2.length];
        int[] result = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            index[i] = i;

        }
        //根据nums2的值升序，来排序nums2的值的对应下标
        //排序后index[]中第一个元素是nums2中最小值的下标，第二个元素是nums2中第二小值的下标
        Arrays.sort(index, (a, b) -> (nums2[a] - nums2[b]));
        int left = 0;
        int right = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[index[left]]) {
                result[index[left]] = nums1[i];
                left++;

            } else {
                result[index[right]] = nums1[i];
                right--;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        int[] re = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(re));

    }

}
