class MyCalendar {
    private List<int[]> ls;
    public boolean check(List<int[]> ls,int x,int y)
    {
        int n = ls.size();
        if(n==0)
        {
            return true;
        }
         for (int i = 0; i < n; i++) {
            int start = ls.get(i)[0];
            int end = ls.get(i)[1];

            if (y <= start) {
                return true;
            }

            if (x >= end) {
                continue;
            }

            return false;
        }
        return true;
    }
    public MyCalendar() {
        ls = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        if(check(ls,startTime,endTime))
        {
            ls.add(new int[]{startTime,endTime});
            Collections.sort(ls,(a,b)->Integer.compare(a[0],b[0]));
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */