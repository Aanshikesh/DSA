class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int num : nums) list.add(num);

        int i = 1;
        while(i < list.size()) {
            if(list.get(i) == list.get(i - 1)) {
                list.remove(i);
                count++;
            }
            else i++;
        }

        return count;
    }
}