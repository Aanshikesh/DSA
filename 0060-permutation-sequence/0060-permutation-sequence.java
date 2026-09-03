class Solution {
    public String getPermutation(int n, int k) {
        char[] chh = new char[n];
        for (int y = 1; y <= n; y++) {
            chh[y - 1] = (char) (y + '0');
        }

        // Advance k - 1 times
        for (int x = 1; x < k; x++) {
            next(chh);
        }

        return new String(chh); // Fix string conversion
    }

    public void next(char[] chh) {
        int i = chh.length - 2;
        while (i >= 0 && chh[i] >= chh[i + 1]) {
            i--;
        }

        if (i >= 0) { // Fix: allow i == 0
            int j = chh.length - 1;
            while (chh[i] >= chh[j]) {
                j--;
            }
            swap(chh, i, j);
        }

        reverse(chh, i + 1);
    }

    public void swap(char[] chh, int i, int j) {
        char t = chh[i];
        chh[i] = chh[j];
        chh[j] = t;
    }

    public void reverse(char[] chh, int i) {
        int left = i, right = chh.length - 1;
        while (left < right) {
            char t = chh[left];
            chh[left] = chh[right];
            chh[right] = t;
            left++;
            right--;
        }
    }
}