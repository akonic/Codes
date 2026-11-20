class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s : dictionary) {
            mp.put(s, 1);
        }
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        List<String> ans = new ArrayList<>();
        int n = words.size();
        for (int i = 0; i < n; i++) {
            char[] arr = words.get(i).toCharArray();
            int p = arr.length;
            StringBuilder a = new StringBuilder();
            boolean f = false;
            for (int j = 0; j < p; j++) {
                a.append(arr[j]);
                if (mp.containsKey(a.toString())) {
                    ans.add(a.toString());
                    j = 10000;
                    f = true;
                }
            }
            if (!f) {
                ans.add(a.toString());
            }
        }
        return String.join(" ", ans);
    }
}