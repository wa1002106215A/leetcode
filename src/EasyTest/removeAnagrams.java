package EasyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeAnagrams {
    public static List<String> removeAnagrams(String[] words) {
        ArrayList<String> list=new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<words.length;i++)
        {
            if (!check(words[i-1],words[i]))
            {
                list.add(words[i]);
            }
        }
        return list;

    }
    public static boolean check(String a, String b){
        char[] A=a.toCharArray();
        char[] B=b.toCharArray();
        if(a.length()!=b.length()) {
            return false;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++)
        {
            if(A[i]!=B[i])
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String[] words={"abba","baba","bbaa","cd","cd"};
        List list=new ArrayList(removeAnagrams(words));

        System.out.println(Arrays.toString(list.toArray()));

    }
}
