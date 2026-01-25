class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        TreeMap<String, List<String>> mp = new TreeMap<>();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            mp.computeIfAbsent(sorted, k -> new ArrayList<>())
                    .add(strs[i]);
        }

        List<List<String>> ls = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : mp.entrySet()) {
            ls.add(e.getValue());
        }
        return ls;
    }
}