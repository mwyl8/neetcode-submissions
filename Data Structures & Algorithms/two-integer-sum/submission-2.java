class Solution {
    public int[] twoSum(int[] nums, int target) {
        int first = 0;
        int second = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) list.add(nums[a]);
        for (int b = 0; b < nums.length; b++) {
            if (list.contains(target - nums[b]) && list.indexOf(target - nums[b]) != b) {
                first = b;
                second = list.indexOf(target - nums[b]);
                break;
            }
        }
        if (first < second) {
            return new int[]{first, second};
        }
        return new int[]{second, first};
    }
}
