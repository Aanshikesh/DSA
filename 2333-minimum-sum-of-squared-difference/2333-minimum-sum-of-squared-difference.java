class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        // Max-heap storing int[]{difference, count}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int n = nums1.length;
        
        // Count frequencies of each difference to avoid 1-by-1 insertions
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }
        }
        
        for (var entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        
        long m = (long) k1 + k2;
        
        while (m > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int val = top[0];
            int count = top[1];
            
            // Next highest value determines how far we can decrease in one step
            int nextVal = pq.isEmpty() ? 0 : pq.peek()[0];
            long diff = val - nextVal;
            long needed = diff * count;
            
            if (m >= needed) {
                m -= needed;
                if (!pq.isEmpty()) {
                    pq.peek()[1] += count; // Merge counts into the next largest level
                } else if (nextVal == 0 && val > 0) {
                    // All elements brought down to zero
                    break;
                }
            } else {
                // Distribute remaining operations
                long dec = m / count;
                int rem = (int) (m % count);
                
                if (val - dec > 0) {
                    pq.offer(new int[]{(int) (val - dec), count - rem});
                }
                if (rem > 0 && val - dec - 1 > 0) {
                    pq.offer(new int[]{(int) (val - dec - 1), rem});
                }
                m = 0;
            }
        }
        
        long sum = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            long a = curr[0];
            long count = curr[1];
            sum += a * a * count;
        }
        return sum;
    }
}