class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        int maxLen = 0;
        for (String s : dictionary) maxLen = Math.max(maxLen, s.length());

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder(sentence.length());
        for (int i = 0; i < words.length; i++) {
            if (i > 0) sb.append(' ');
            String w = words[i];
            int lim = Math.min(w.length(), maxLen);
            String best = w;
            for (int j = 1; j <= lim; j++) {
                String pre = w.substring(0, j);
                if (set.contains(pre)) { best = pre; break; }
            }
            sb.append(best);
        }
        return sb.toString();
    }
}