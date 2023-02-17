import java.util.*;

/*
 * letter case permutation
 */

public class leetcode784 {
    static List<String> ans;

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("A1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        helperPermutation(s, 0);
        return ans;
    }

    public static void helperPermutation(String s, int index) {
        if (index >= s.length()) {
            ans.add(s);
            return;
        }
        char ch = s.charAt(index);
        if (ch >= '0' && ch <= '9') {
            helperPermutation(s, index + 1);
            return;
        }
        helperPermutation(s, index + 1);
        String modifiedString = "";
        if (index == 0) {
            char chTomodify = ch >= 65 && ch <= 90
                    ? (char) (ch + 32)
                    : (char) (ch - 32);
            modifiedString = chTomodify + s.substring(index + 1);
        } else {
            char chTomodify = ch >= 65 && ch <= 90
                    ? (char) (ch + 32)
                    : (char) (ch - 32);

            modifiedString = s.substring(0, index) + chTomodify
                    + s.substring(index + 1);
        }
        helperPermutation(modifiedString, index + 1);
    }

}