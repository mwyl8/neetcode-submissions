class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (list.contains(nums[a])) {
                return true;
            }
            list.add(nums[a]);
        }
        return false;
    }
}