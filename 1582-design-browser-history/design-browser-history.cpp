class BrowserHistory {
public:
    list<string> list1;
    list<string>::iterator it = list1.begin();
    BrowserHistory(string homepage) {
        list1.push_front(homepage);
        it=find(list1.begin(), list1.end(), homepage);
    }
    
    void visit(string url) {
        auto next_it = std::next(it);
        
        if (next_it != list1.end()) {
            list1.erase(next_it, list1.end());
        }

        list1.push_back(url);
        it = std::prev(list1.end());
    }
    
    string back(int steps) {
        while(steps > 0 && it != list1.begin())
        {
            --it;
            steps--;
        }
        return *it;
    }
    
    string forward(int steps) {
        while (steps > 0 && next(it) != list1.end()) {
            ++it;   
            --steps;
        }
        return *it;
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */