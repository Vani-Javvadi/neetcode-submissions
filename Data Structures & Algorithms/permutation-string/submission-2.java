class Solution {
    private boolean valid(int[] cnt1, int[] cnt2) {
        for(int i=0; i<26; i++) {
            if(cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] cnt1 = new int[26];
        for(int i=0; i<n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
        }

        int[] cnt2 = new int[26];
        int l=0, r=0;
        while(r < m) {
            cnt2[s2.charAt(r) - 'a']++;
            if(r-l+1 > n) {
                cnt2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(r-l+1 == n) {
                // check if the window of s2 is permutation of s1
                if(valid(cnt1, cnt2)) {
                    return true;
                }
            }
            
            r++;
        }
        return false;
    }
}
