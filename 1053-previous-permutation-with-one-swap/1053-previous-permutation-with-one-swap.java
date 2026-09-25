class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        pq.offer(new int[] { arr[n - 1], n - 1 });
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                while (!pq.isEmpty() && arr[i] <= pq.peek()[0]) {
                    pq.poll();
                }
                if (pq.isEmpty())
                    continue;
                int t = arr[i];
                arr[i] = pq.peek()[0];
                arr[pq.peek()[1]] = t;
                break;
            }
            pq.offer(new int[] { arr[i], i });
        }
        return arr;
    }
}