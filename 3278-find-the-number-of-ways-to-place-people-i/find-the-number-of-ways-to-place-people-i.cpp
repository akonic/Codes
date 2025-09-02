class Solution {
public:
    int numberOfPairs(vector<vector<int>>& points) {
        int n = points.size();
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                if (x1 <= x2 && y1 >= y2) {
                    bool valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int px = points[k][0], py = points[k][1];

                        if (px >= x1 && px <= x2 &&
                            py <= y1 && py >= y2) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) c++;
                }
            }
        }
        return c;
    }
};
