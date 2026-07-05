class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int a = 0; a < ans.length; a++) {
            int numsIndex = a;
            if (numsIndex > nums.length - 1) {
                numsIndex -= nums.length;
            }
            ans[a] = nums[numsIndex];
        }
        return ans;
    }
}