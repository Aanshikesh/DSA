class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] car=  new int[n][2];
        for(int i=0;i<n;i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car,(a,b)-> a[0]-b[0]);
        Deque<Double> stack = new ArrayDeque<>();
        for(int [] c: car ){
            double time= (target - c[0]) / (double)c[1];
            while(!stack.isEmpty() && stack.peek()<=time){
                stack.pop();
            }
            stack.push(time);
        }
        return stack.size();
    }
}