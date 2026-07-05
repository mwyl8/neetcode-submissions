class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // Only start counting from the beginning of a sequence
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}