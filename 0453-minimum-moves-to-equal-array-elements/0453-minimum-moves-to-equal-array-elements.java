class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        // PriorityQueue<Integer> q = new  PriorityQueue<>();
        // Map<Integer,Integer> map=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     q.add(nums[i]);
        // }
        // int ans=0;
        // while(map.size()!=1){
        //     PriorityQueue<Integer> pq = new  PriorityQueue<>();
        //     for(int i=0;i<n-1;i++){
        //         int x=q.poll();
        //         int y=map.get(x);
        //         if(y==1) map.remove(x);
        //         else map.put(x,y-1);
        //         map.put(x+1,map.getOrDefault(x+1,0)+1);
        //         pq.add(x+1);
        //     }
        //     pq.add(q.poll());
        //     while(!pq.isEmpty()){
        //         q.add(pq.poll());
        //     }
        //     ans++;
        // }
        // return ans;
        int sum=0,min=(int)1e9;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            min=Math.min(min,nums[i]);
        }
        return sum-min*n;
    }
}