package EasyTest;

import java.util.Scanner;

public class divisorGame {
    public static boolean divisorGame(int n) {
        if (n % 2 == 0)
            return true;
        else
            return false;


    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(divisorGame(n));
            if (n == 88)
                break;
        }


    }
}
