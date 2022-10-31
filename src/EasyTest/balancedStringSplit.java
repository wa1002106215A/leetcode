package EasyTest;

import java.util.Scanner;

public class balancedStringSplit {
    public static int balancedStringSplit(String s) {
        int l = 0,r=0;
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='L')
            {
                l++;
            }
            else
                r++;
            if(l==r)
                ans++;

        }
        return ans;


    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(balancedStringSplit(s));

    }
}
