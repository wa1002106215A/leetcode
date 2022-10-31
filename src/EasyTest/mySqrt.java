package EasyTest;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class mySqrt {
    public static int mySqrt(int x) {

        if (x == 1) {
            return 1;
        }
        int min=0;
        int max=x;
        while(max-min>1){
            int m=(max+min)/2;
            if (x/m<m){
                max=m;
            }
            else {
                min=m;
            }

        }
        return min;

    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
}
