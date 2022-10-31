package EverydayTest;

import javax.management.Query;
import java.util.*;

/**
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 */

public class scoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        Stack stack = new Stack();
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                flag = true;
            } else {
                if (flag) {
                    sum += Math.pow(2, stack.size() - 1);
                    flag = false;
                }
                stack.pop();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println(scoreOfParentheses(s));
        }
    }
}
