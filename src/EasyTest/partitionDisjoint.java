package EasyTest;

/**
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 */
public class partitionDisjoint {
    public static int partitionDisjoint(int[] nums) {
        //如果一个数组可以划分为两个连续子数组，那么必须要保证left里的最大值小于等于right
        //这代表着必然存在右边的连续数组全部大于左边的
        int res=1;
        int max=nums[0],leftmax=nums[0];
        for(int i=1;i<nums.length;i++){
            //从左往右遍历，若遇到比max大的更新max
            //遇到比leftmax小的，更新res和leftmax，res代表长度
            if(nums[i]>max){
                max=nums[i];
            }else if(nums[i]<leftmax){
                leftmax=max;
                res=i+1;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums= {5,0,3,8,6};
        System.out.println(partitionDisjoint(nums));
    }

}
