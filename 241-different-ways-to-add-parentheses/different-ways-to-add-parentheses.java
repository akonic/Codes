class Solution {

    private List<Integer> helper(String s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftResults = helper(s.substring(0, i));
                List<Integer> rightResults = helper(s.substring(i + 1));

                for (int x : leftResults) {
                    for (int y : rightResults) {
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);

    }
}