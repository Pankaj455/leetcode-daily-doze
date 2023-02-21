/*
 * single element in a sorted array in logn time
 */

public class leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while (left <= right) {
            if (nums[left + 1] != nums[left]) {
                ans = nums[left];
                break;
            } else if (nums[right - 1] != nums[right]) {
                ans = nums[right];
                break;
            }
            left += 2;
            right -= 2;
        }
        return ans;
    }
}
