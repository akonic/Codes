class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Integer> ls = new ArrayList<>();
        int x=1;
        while(x<=1000000000)
        {
            ls.add(x);
            x*=2;
        }
        Map<Integer,int[]> mp = new HashMap<>();
        for(int i : ls)
        {
            int temp=i;
            int[] arr = new int[10];
            while(temp>0)
            {
                arr[temp%10]++;
                temp/=10;
            }
            // System.out.println(i);
            // for(int c : arr)
            // {
            // System.out.println(c);}
            // System.out.println("-------------");
            mp.put(i,arr);
        }
        int[] check = new int[10];
        int temp=n;
        while(temp>0)
        {
            check[temp%10]++;
            temp/=10;
        }
        for (Map.Entry<Integer, int[]> entry : mp.entrySet()) {
            boolean flag=true;
            int[] arr = entry.getValue();
            for(int i=0;i<10;i++)
            {
                if(arr[i]!=check[i])
                {
                    flag=false;
                }
            }
            if(flag)
            {
                return true;
            }

        }

        return false;
    }
}