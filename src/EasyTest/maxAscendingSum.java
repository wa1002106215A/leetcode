package EasyTest;

public class maxAscendingSum {
    public static int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int i;
        int max=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                sum+=nums[i+1];

        //        System.out.println("'"+nums[i+1]+"'");

            }
            else {
                if (max<sum){
                    max=sum;
                }
                sum=nums[i+1];
            }
        }
        if (max<sum){
            max=sum;
        }
        return max;


    }

    public static void main(String[] args) {
        int[] nums= {3,6,10,1,8,9,9,8,9};
        System.out.println("max="+maxAscendingSum(nums));
    }
}
