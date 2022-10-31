package EasyTest;

import java.util.Stack;

public class removeDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char str=s.charAt(i);
            if(stack.empty()||stack.peek()!=str){
                stack.push(str);
            }else{
                stack.pop();
            }

        }
        StringBuilder ss=new StringBuilder();
        while(!stack.empty()){
            ss.append(stack.pop());
        }
        return ss.reverse().toString();

    }

    public static void main(String[] args) {
        String s="abbaca";
        System.out.println(removeDuplicates(s));
    }
}
