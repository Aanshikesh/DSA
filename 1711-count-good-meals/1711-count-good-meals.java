class Solution {
    public int countPairs(int[] nums) {
        int n=nums.length;
HashSet<Integer> set=new HashSet<>();
        int c=1;
        set.add(1);
        for(int x=1;x<=21;x++){
            c*=2;
        set.add(c);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
         
        for(int x=0;x<n;x++){
            map.put(nums[x],map.getOrDefault(nums[x],0)+1);
            for(int y:set){
                int comp=y-nums[x];
                if(map.containsKey(comp)){
                    if(comp==nums[x])
                    count=(count+map.get(comp)-1)%1000000007;
                    else
                    count=(count+map.get(comp))%1000000007;
                } 
            }
        }
        return count;
    }
}