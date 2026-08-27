class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int count=0;
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='1'){
                    count++;
                    sb.append(1);
                }
                if(s.charAt(j)=='0' && sb.length()>0){
                    sb.append(s.charAt(j));
                }
                if(k==count){
                    list.add(sb.toString());
                    break;
                }
            }
        }
        if(list.size()==0) return "";
        Collections.sort(list);
        String ans=list.get(0);
        for(String str:list){
            if(str.length()<ans.length() ||
                (str.length()==ans.length() &&
                 str.compareTo(ans)<0)){
                ans=str;
            }
        }
        return ans;
    }
}