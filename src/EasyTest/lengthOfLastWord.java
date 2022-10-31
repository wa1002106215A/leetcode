package EasyTest;

//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
//        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

import java.util.Stack;

public class lengthOfLastWord {
    //    public static int lengthOfLastWord(String s) {
//        Stack stack = new Stack();
//        char top;
//        int count = 0;
//        int countempty=0;
//        char[] str = s.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            stack.push(str[i]);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            top = (char) stack.peek();
//            if (top == ' ') {
//                stack.pop();
//                countempty++;
//            } else
//                break;
//
//        }
//        for (int i = 0; i < s.length()-countempty; i++) {
//            top = (char) stack.peek();
//            if (top != ' ') {
//
//                stack.pop();
//                count++;
//            } else
//                break;
//
//        }
//        return count;
//
//    }
    public static int lengthOfLastWord(String s) {
        int count=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)!=' ')
            {
                count++;
            }
            else if (count!=0){
                return count;
            }


        }
        return count;

    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }
}
