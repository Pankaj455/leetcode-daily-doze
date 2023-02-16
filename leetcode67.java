public class leetcode67 {
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int al = a.length() - 1, bl = b.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (al >= 0 && bl >= 0) {
            // b1 & b2 -> binary characters of a and b respectively
            char b1 = a.charAt(al);
            char b2 = b.charAt(bl);
            if (b1 == '1' && b2 == '1') {
                ans.insert(0, carry == 1 ? '1' : '0');
                carry = 1;
            } else if (b1 == '0' && b2 == '0') {
                ans.insert(0, carry == 1 ? '1' : '0');
                carry = 0;
            } else {
                ans.insert(0, carry == 1 ? '0' : '1');
            }
            al--;
            bl--;
        }
        while (al >= 0) {
            char b1 = a.charAt(al);
            if ((b1 == '1' && carry == 1) || (b1 == '0' && carry == 0)) {
                ans.insert(0, '0');
            } else {
                ans.insert(0, '1');
                carry = 0;
            }
            al--;
        }
        while (bl >= 0) {
            char b2 = b.charAt(bl);
            if ((b2 == '1' && carry == 1) || (b2 == '0' && carry == 0)) {
                ans.insert(0, '0');
            } else {
                ans.insert(0, '1');
                carry = 0;
            }
            bl--;
        }

        if (carry == 1) {
            ans.insert(0, '1');
            return ans.toString();
        }

        return ans.toString();
    }

}
