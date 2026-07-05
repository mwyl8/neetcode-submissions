class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int rem = curSum % k;
            if (remainderIndex.containsKey(rem)) {
                if (i - remainderIndex.get(rem) > 1) return true;
            } else {
                remainderIndex.put(rem, i);
            }
        }
        return false;
    }
}