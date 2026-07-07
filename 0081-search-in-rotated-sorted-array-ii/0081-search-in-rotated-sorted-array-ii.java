class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[s] && nums[mid]== nums[e] ){
                e = e-1;
                s = s+1;
                continue;
            }
            if(nums[mid]>=nums[s]) {
            if(target>=nums[s] && target<nums[mid]){
                e = mid-1;
            }
            else s = mid+1;
            }
            else {if(target>nums[mid] && target<=nums[e]){
                 s= mid +1;
            }
            else e = mid-1;
            }
        }
        return false;
    }
}    
   