import java.util.*;

class leetcode989 {
    public static void main(String args[]) {
        int[] arr = { 9, 9, 9 };
        System.out.println(addToArrayForm(arr, 1111));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int kLength = count(k);
        int size = Math.max(kLength, num.length);
        int ans[] = new int[size + 1];
        int carry = 0, i = num.length - 1, p = size;
        while (i >= 0 && k > 0) {
            int digit = k % 10;
            k /= 10;
            int sum = num[i] + digit + carry;
            ans[p] = sum % 10;
            carry = sum / 10;
            i--;
            p--;
        }
        while (i >= 0) {
            int sum = num[i] + carry;
            ans[p] = sum % 10;
            carry = sum / 10;
            i--;
            p--;
        }
        while (k > 0) {
            int digit = k % 10;
            k /= 10;
            int sum = ans[p] + digit + carry;
            ans[p] = sum % 10;
            carry = sum / 10;
            p--;
        }
        if (carry > 0)
            ans[p] = carry;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < ans.length; j++) {
            if (j == 0 && ans[j] == 0)
                continue;
            list.add(ans[j]);
        }
        return list;
    }

    public static int count(int num) {
        int c = 0;
        while (num > 0) {
            num /= 10;
            c++;
        }
        return c;
    }

}