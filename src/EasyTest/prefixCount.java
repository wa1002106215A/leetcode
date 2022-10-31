package EasyTest;

/**
 * 给你一个字符串数组 words 和一个字符串 pref 。
 * <p>
 * 返回 words 中以 pref 作为 前缀 的字符串的数目。
 * <p>
 * 字符串 s 的 前缀 就是s 的任一前导连续字符串。
 */
public class prefixCount {
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < pref.length()) {
                continue;
            }
            for (int j = 0; j < pref.length(); j++) {
                flag = true;
                if (words[i].charAt(j) != pref.charAt(j)) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                count++;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }
}
