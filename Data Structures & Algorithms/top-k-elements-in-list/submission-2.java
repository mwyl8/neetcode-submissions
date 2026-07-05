class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> priority = new PriorityQueue<>();
        Arrays.sort(nums);
        int[] topK = new int[k];
        int tracker = 0;

        for (int a = 0; a < nums.length; a++) {
            tracker++;
            if (a < nums.length - 1) {
                if (nums[a + 1] != nums[a]) {
                    if (!map.containsKey(nums[a])) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(tracker);
                        map.put(nums[a], temp);
                    } else {
                        ArrayList<Integer> temp = map.get(nums[a]);
                        temp.add(tracker);
                        map.put(nums[a], temp);
                    }
                    priority.add(tracker);
                    tracker = 0;
                }
            } else {
                if (!map.containsKey(nums[a])) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(tracker);
                    map.put(nums[a], temp);
                } else {
                    ArrayList<Integer> temp = map.get(nums[a]);
                    temp.add(tracker);
                    map.put(nums[a], temp);
                }
                priority.add(tracker);
                tracker = 0;
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        while (!priority.isEmpty()) {
            stack.push(priority.poll());
        }

        int b = 0;
        while (b < k) {
            int freq = stack.pop();
            int foundKey = Integer.MIN_VALUE;
            for (int key : map.keySet()) {
                if (map.get(key).contains(freq)) {
                    foundKey = key;
                    break;
                }
            }
            topK[b] = foundKey;
            map.remove(foundKey);
            b++;
        }
        return topK;
    }
}