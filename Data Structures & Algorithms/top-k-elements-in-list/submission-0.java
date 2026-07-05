class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map: number -> frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Min-heap ordered by frequency (size capped at k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for (int num : freqMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }

        // Drain heap into result
        int[] topK = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topK[i] = minHeap.poll();
        }
        return topK;
    }
}