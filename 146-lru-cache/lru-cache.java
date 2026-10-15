class LRUCache {
    List<int[]> ls;
    int c = 0;

    public LRUCache(int capacity) {
        ls = new ArrayList<>();
        c = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < ls.size(); i++) {
            int[] top = ls.get(i);
            if (top[0] == key) {
                ls.remove(i);
                ls.add(top);
                return top[1];
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i)[0] == key) {
                ls.remove(i);
                ls.add(new int[] { key, value });
                return;
            }
        }
        if (ls.size() == c) {
            ls.remove(0);
        }
        ls.add(new int[] { key, value });

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */