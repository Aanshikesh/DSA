class Solution {
    public int minOperations(String s1, String s2) {
    if (s1.equals("1")) {
        if (s2.equals("0")) {
            return -1;
        }
    }

    char[] s = s1.toCharArray();
    int res = 0;
    int n = s1.length();

    for (int i = 0; i < n; i++) {

        if (s[i] == s2.charAt(i)) {
            continue;
        }

        res++;

        if (s[i] == '1') {

            if (i == n - 1) {
                res++;
            } else {

                if (s[i + 1] == '0') {
                    res++;
                }

                s[i + 1] = '0';
            }
        }
    }

    return res;
}
}