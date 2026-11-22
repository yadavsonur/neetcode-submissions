class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Find min and max to size the frequency array tightly
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // 2. Count frequencies using a primitive array (zero autoboxing)
        int[] freq = new int[max - min + 1];
        int maxFreq = 0;
        for (int num : nums) {
            int f = ++freq[num - min];
            if (f > maxFreq) maxFreq = f;
        }

        // 3. Bucket sort up to maxFreq (saves scanning empty trailing buckets)
        List<Integer>[] buckets = new List[maxFreq + 1];
        for (int i = 0; i < freq.length; i++) {
            int f = freq[i];
            if (f > 0) {
                if (buckets[f] == null) {
                    buckets[f] = new ArrayList<>();
                }
                buckets[f].add(i + min);
            }
        }

        // 4. Collect top k elements from highest frequency down
        int[] result = new int[k];
        int idx = 0;
        for (int f = maxFreq; f > 0 && idx < k; f--) {
            if (buckets[f] != null) {
                for (int num : buckets[f]) {
                    result[idx++] = num;
                    if (idx == k) return result;
                }
            }
        }
        return result;
    }
}
