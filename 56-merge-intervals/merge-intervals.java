class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> answer = new ArrayList<>();
        int x = intervals[0][0], y = intervals[0][1];
        for (int[] in : intervals) {
            if (in[0] > y) {
                answer.add(new int[] { x, y });
                x = in[0];
                y = in[1];
            }
            else{
                y = Math.max(y, in[1]);
            }
        }
        answer.add(new int[] { x, y });
        return answer.toArray(new int[answer.size()][]);
    }
}