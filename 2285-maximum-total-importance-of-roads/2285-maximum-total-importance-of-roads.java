class Solution {
    public long maximumImportance(int n, int[][] roads) {
    long degree[] = new long[n];
    for(int i=0;i<roads.length;i++){
        degree[roads[i][0]]++;
        degree[roads[i][1]]++;

    }
    Arrays.sort(degree);  
    long sum=0;
     for(int i=0;i<n;i++){
        sum+= degree[i]*(i+1);
    } 
    return sum;
    }
}