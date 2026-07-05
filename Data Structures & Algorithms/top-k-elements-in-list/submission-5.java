class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> map.get(n2) - (map.get(n1)));
        
        for (int key : map.keySet()) {
            heap.offer(key);
        }
        int[] topK = new int[k];
        for (int x = 0; x < k; x++) {
            topK[x] = heap.poll();
        }
        return topK;
    }
}
