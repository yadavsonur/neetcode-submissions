class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mmap = new HashMap<>();
        for (int num : nums) {
            mmap.put(num, mmap.getOrDefault(num, 0) + 1);
        }

        // Min-heap ordered by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> mmap.get(a) - mmap.get(b)
        );

        for (int key : mmap.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
