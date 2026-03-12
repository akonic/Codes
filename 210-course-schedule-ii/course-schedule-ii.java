class Solution {
     void helper(ArrayList<ArrayList<Integer>> list,int[] visited, Stack<Integer> stack,int node)
    {
        visited[node]=1;
        for(int i : list.get(node))
        {
            if(visited[i]==0)
            {
               helper(list, visited, stack, i);
                
            }
        }
        stack.push(node);
    }
    public boolean check(ArrayList<ArrayList<Integer>> list,int[] visited, int[] inRec,int node)
    {
        visited[node]=1;
        inRec[node]=1;
        for(int i : list.get(node))
        {
            if(visited[i]==0)
            {
               if(check(list, visited, inRec, i))
                    return true;
            }
            else if(inRec[i]==1)
            {
                return true;
            }
        }
        inRec[node]=0;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            list.add(new ArrayList<>());
        }
        int n=prerequisites.length;
        for(int i=0;i<n;i++)
        {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        int[] inRec = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            visited[i]=0;
            inRec[i]=0;
        }
        int[] ans = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==0 && check(list,visited,inRec,i))
            {
                return new int[0];
            }
        }
        for(int i=0;i<numCourses;i++)
        {
            visited[i]=0;
        }
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==0)
            {
                helper(list,visited,stack,i);
            }
        }
        
        int i=0;
        while(!stack.empty())
        {
            ans[i]=stack.peek();i++;
            stack.pop();
        }
        return ans;
    }
}