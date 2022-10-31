package EverydayTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 */
public class areAlmostEqual {
    public static boolean areAlmostEqual(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int i;
        ArrayList<Integer> num = new ArrayList<Integer>();
        char t;
        int numl = 0;
        boolean flag = true;
        if (s1.equals(s2)){
            return true;
        }
        for (i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                break;
            }
        }
        if(i==arr1.length-1){
            return false;
        }
        for (int j = i + 1; j < arr1.length; j++) {
            if (arr1[j] != arr2[j]) {
                num.add(j);
                numl++;
            }
        }
        if(num.isEmpty())
        {
            return false;
        }
        for (int j = 0; j < numl; j++) {
            t = arr1[i];
            arr1[i] = arr1[num.get(j)];
            arr1[num.get(j)] = t;
            for (int k = 0; k < arr1.length; k++) {
                if (arr1[k] != arr2[k]) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                break;
            }

        }
        return flag;

    }

    public static void main(String[] args) {
        String s1 = "kkel";
        String s2 = "kkel";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
