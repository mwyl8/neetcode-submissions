class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            map.put(num, nums.length / 3 + 1);
        }

        for (int num : nums) {
            if (!map.containsKey(num)) continue; // already removed

            map.put(num, map.get(num) - 1);

            if (map.get(num) == 0) {
                list.add(num);
                map.remove(num);
            }
        }

        return list;
    }
}