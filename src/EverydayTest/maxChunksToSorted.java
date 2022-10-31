package EverydayTest;

/**
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * <p>
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 */
public class maxChunksToSorted {
    public static int maxChunksToSorted(int[] arr) {
        int max=arr[0];
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
            if (max==i){
                count++;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr={1,2,0,3};
        System.out.println(maxChunksToSorted(arr));
    }
}
