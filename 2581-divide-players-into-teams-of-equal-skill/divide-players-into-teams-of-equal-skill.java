class Solution {
    public long dividePlayers(int[] skill) {
        long ans=0;
        Arrays.sort(skill);
        int n=skill.length;
        int p=skill[0]+skill[n-1];
        for(int i=0;i<n/2;i++)
        {
            if(skill[i]+skill[n-i-1] != p)
            {
                return -1;
            }
            ans+=(long)skill[i]*(long)skill[n-i-1];
        }
        return ans;
    }
}