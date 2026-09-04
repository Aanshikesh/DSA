class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) {
                continue;
            }

            sb.append(str[i]);

            if (sb.length() > 0) {
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}