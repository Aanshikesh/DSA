class Solution {
    public String reverseWords(String s) {
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    String result = s.trim();
    for(int i=0;i<result.length();i++){
        if(result.charAt(i)==' ' && sb.length()!=0){ stack.push(sb.toString());
        sb.setLength(0);
        continue;
        }
        if(result.charAt(i)!=' '){sb.append(result.charAt(i));}
    }
    stack.push(sb.toString());
    sb.setLength(0);
    while(!stack.isEmpty()){
        sb.append(stack.pop());
        if(!stack.isEmpty()) sb.append(' ');
    }
    return sb.toString();
    }
}