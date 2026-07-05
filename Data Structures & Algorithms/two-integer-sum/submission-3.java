class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a = 0; a < nums.length; a++) {
            if (map.containsKey(target - nums[a])) {
                return new int[] {map.get(target - nums[a]), a};
            }
            map.put(nums[a], a);
        }
        return new int[]{0, 0};
    }
}
