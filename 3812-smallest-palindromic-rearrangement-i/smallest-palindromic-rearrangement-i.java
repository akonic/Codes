class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==1)
        {
            return s;
        }
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        char[] ch = new char[n];
        Arrays.fill(ch, '0');
        if (n % 2 == 0) {
            int i = 0, j = n - 1, k = 0;
            while (i < j && k<26) {
                int temp = freq[k];
                while (temp > 0) {
                    ch[i] = (char) (97 + k);
                    ch[j] = (char) (97 + k);
                    i++;
                    j--;
                    temp -= 2;
                }
                k++;
            }
        } else {
            char p ='0';
            int i = 0, j = n - 1, k = 0;
            while (i <=j && k<26) {
                int temp = freq[k];
                if(temp%2==1)
                {
                    p=(char)(97+k);
                    temp--;
                }
                while (temp > 0) {
                    ch[i] = (char) (97 + k);
                    ch[j] = (char) (97 + k);
                    i++;
                    j--;
                    temp -= 2;
                }
                k++;
            }
            ch[n/2]=p;
        }

        return String.valueOf(ch);
    }
}