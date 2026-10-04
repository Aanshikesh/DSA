class Solution {
    public String longestWord(String[] words) {

        Arrays.sort(words, (a, b) ->
            a.length() == b.length()
                ? a.compareTo(b)
                : a.length() - b.length()
        );

        Set<String> possible = new HashSet<>();
        possible.add("");

        String res = "";

        for (String word : words) {

            if (possible.contains(
                    word.substring(0, word.length() - 1))) {

                possible.add(word);

                if (word.length() > res.length()) {
                    res = word;
                }
            }
        }

        return res;
    }
}