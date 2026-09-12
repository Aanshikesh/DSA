class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] freq = new int[101];
        int count=0;
        for(int num: nums) freq[num]++;
    
        for(int j=0;j<101;j++){
            if(freq[j]==3){
                int num = j;
                int s=-1,m=-1,e=-1;
                System.out.println(num);
                for(int i =0;i<nums.length;i++){
                    if(s==-1 && nums[i]==num) s=i;
                    else if(s!=-1 && m==-1 && nums[i]==num) m=i;
                    else if(s!=-1 && m!=-1 && e ==-1 && nums[i]==num) e=i;
                }
                System.out.println(s+ " " + m + " " + e);
                if(s!=-1 && m!=-1 && e!=-1 && (m-s)==(e-m)) count++;
            }
        }
        return count;
    }
}