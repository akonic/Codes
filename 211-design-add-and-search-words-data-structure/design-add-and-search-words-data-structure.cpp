class WordDictionary {
private:


public:
unordered_map<int, vector<string>> byLen;

    WordDictionary() = default;

    void addWord(const string& word) {
        byLen[word.size()].push_back(word);
    }

    bool check(const string& a, const string& b) {
        int n = a.size();
        for (int i = 0; i < n; ++i) {
            if (b[i] != '.' && b[i] != a[i]) return false;
        }
        return true;
    }

    bool search(const string& word) {
        auto it = byLen.find(word.size());
        if (it == byLen.end()) return false;
        for (const string& w : it->second) {
            if (check(w, word)) return true;
        }
        return false;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */