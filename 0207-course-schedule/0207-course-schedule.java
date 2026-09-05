class Solution {
    public boolean canFinish(int n, int[][] p) {
        int[] in = new int[n];
        for(int i =0;i<p.length;i++ ){
            in[p[i][0]]++;
        }
        List<List<Integer>> arr  = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] pair :p){
                arr.get(pair[1]).add(pair[0]);

        }
        Queue<Integer> q = new LinkedList<>();
        for(int i= 0;i<n;i++){
            if(in[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int val: arr.get(node)){
                in[val]--;
                if(in[val]==0) q.offer(val);
            }

        }
        for(int i=0;i<n;i++){
            if(in[i]!=0) return false;
        }
        return true;
    }
}