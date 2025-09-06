class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> words(wordList.begin(), wordList.end());
        if (words.find(endWord) == words.end()) return 0;

        queue<pair<string,int>> q;
        q.push({beginWord, 1}); 
        if (words.count(beginWord)) words.erase(beginWord);

        while (!q.empty()) {
            auto [cur, level] = q.front(); q.pop();
            if (cur == endWord) return level;

            string next = cur;
            for (int i = 0; i < (int)cur.size(); ++i) {
                char orig = next[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == orig) continue;
                    next[i] = c;
                    if (words.find(next) != words.end()) {
                        q.push({next, level + 1});
                        words.erase(next); // mark visited
                    }
                }
                next[i] = orig;
            }
        }
        return 0;
    }
};
