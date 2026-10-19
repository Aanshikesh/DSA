class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });
        for(int i =0;i<n;i++){
            int[] a = {nums[i],i};
            pq.add(a);
        }
        long score =0;
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int a1 = a[0];
            int idx = a[1];
            if(nums[idx]==0) continue;
            nums[idx] =0;
            score+=(long)a1;
            if(idx>=1 && idx<n) nums[idx-1]=0;
            if(idx>=0 && idx<n-1) nums[idx+1] =0; 
        }
        return score;
    }
}