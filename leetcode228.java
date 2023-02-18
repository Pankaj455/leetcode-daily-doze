import java.util.*;

/*
 * Summary ranges
 */
public class leetcode228 {
    public static void main(String[] args) {
        int nums[] = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        int low = nums[0];
        int high = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == high + 1)
                high = nums[i];
            else {
                if (low == high) {
                    ans.add(low + "");
                } else {
                    ans.add(low + "->" + high);
                }
                low = high = nums[i];
            }
        }
        if (low == high) {
            ans.add(low + "");
        } else {
            ans.add(low + "->" + high);
        }
        return ans;
    }
}
