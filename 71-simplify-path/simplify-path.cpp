class Solution {
public:
    string simplifyPath(string path) {
        stack<string> s;
        vector<string> v;
        string u;
        int i = 0;
        int n = (int)path.size();
        while (i < n)
        {
            if (path[i] == '/')
            {
                if (s.size() != 0 && s.top() == "/")
                {
                    i++;
                }
                else {
                    s.push(string(1, path[i]));
                    i++;
                }
            }
            else if (path[i] == '.')
            {
                string p;
                while (i < n && path[i] != '/')
                {
                    p += path[i];
                    i++;
                }
                // minimal fixes here:
                if (p == "..")
                {
                    if (s.size() <= 1)
                    {

                    }
                    else {
                        s.pop();
                        s.pop();
                    }
                }
                else if (p != ".")   // push any dot-component that's not "." or ".."
                {
                    s.push(p);
                }
            }
            else {
                string p;
                while (i < n  && path[i] != '/')
                {
                    p += path[i];
                    i++;
                }
                s.push(p);
            }

        }
        while (!s.empty())
        {
            v.push_back(s.top());
            s.pop();
        }
        reverse(v.begin(), v.end());

        // safe concatenation loop (no change)
        if (v.size() >= 2) {
            for (size_t j = 0; j + 1 < v.size(); ++j) {
                u += v[j];
            }
        }
        if (v.size() != 1) {
            if (!v.empty() && v.back() != "/") {
                u += v.back();
            }
        }
        if (v.size() == 1)
        {
            u += v.back();
        }

        return u;
    }
};
