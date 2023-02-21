/*
 * string to integer
 */

public class leetcode8 {
    public static void main(String[] args) {
        System.out.println("ans: " + myAtoi("+-12"));
    }

    public static int myAtoi(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        int i = 0;
        long result = 0;
        boolean negative = false;
        char ch = s.charAt(i);
        if (ch == ' ') {
            while (ch == ' ') {
                i++;
                if (i < n)
                    ch = s.charAt(i);
                else
                    break;
            }
        }
        while (i < n) {
            ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result = result * 10 + (ch - '0');
                if (result >= (long) MAX && !negative) {
                    result = MAX;
                    break;
                } else if ((result * -1) <= (long) MIN) {
                    result = MIN;
                    break;
                }
            } else if (ch == '+') {
                if (result > 0)
                    break;
                else if (i > 0 && (s.charAt(i - 1) == '-' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '0')) {
                    result = 0;
                    break;
                }
            } else if (ch == '-') {
                if (negative || result > 0)
                    break;
                else if (i > 0 && (s.charAt(i - 1) == '-' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '0')) {
                    result = 0;
                    break;
                }
                negative = true;
            } else {
                break;
            }
            i++;
        }

        if (negative && result > 0) {
            result *= (long) -1;
        }
        return (int) result;
    }
}
