class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add((long)num);
        }
        long score =0;
        while(k>0){
            long a  = pq.poll();
            score+= a;
            a= (long)Math.ceil(a*1.0/3);
            pq.add(a);
            k--;
        }
        return score;

    }
}