
/*
 * basic calculator II
 */
// import java.util.Stack;

public class leetcode227 {
    public static void main(String[] args) {
        String exp = "4*8/8-8/2+4";
        System.out.println(calculate(exp));
    }

    static int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int len = s.length();
        // Stack<Integer> stack = new Stack<Integer>();
        int currentNum = 0, lastNum = 0, ans = 0;
        char currentOp = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNum = (currentNum * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (currentOp == '-') {
                    // stack.push(-currentNum);
                    ans += lastNum;
                    lastNum = -currentNum;
                } else if (currentOp == '+') {
                    // stack.push(currentNum);
                    ans += lastNum;
                    lastNum = currentNum;
                } else if (currentOp == '*') {
                    // stack.push(stack.pop() * currentNum);
                    lastNum = currentNum * lastNum;
                } else if (currentOp == '/') {
                    // stack.push(stack.pop() / currentNum);
                    lastNum = lastNum / currentNum;
                }
                currentOp = currentChar;
                currentNum = 0;
            }
        }
        ans += lastNum;
        return ans;
    }
}
