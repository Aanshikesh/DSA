class Solution {
    public List<String> largestString(int[] nums) {
        
        long[] convert = new long[26];
        long base = 1;

        for(int i = 0; i < 26; i++){
            convert[i] = base;
            base *= 2;
        }

        List<String> res = new ArrayList<>();

        for(int n : nums){
            StringBuilder cur = new StringBuilder();

           
            while(n > 0){
                int i = 25;

                while(convert[i] > n){
                    i--;
                }

                cur.append((char)('a' + i));
                n -= convert[i];
            }

            res.add(cur.toString());
        }

        return res;
    }
}