class Solution {
    public String minWindow(String s, String t) {
        // BF - we will form all substring and check if all character of xyz is present in substring 
        // to do that we will use cnt array , we will compare cnt_t with cnt_s 
        // for all the characters in t if cnt_s value is euqal to cnt_t, the valid substring 
        // we will consider its length , at the end after checking all substring , we will return min length substring

        // TC - O(N^2)
        // Sc - O(26)

        // optima - O(N) - Sliding window 
        // find a valid window and update the length 
        int n = s.length();
        int m = t.length();
        int l=0, r=0, length=n;
        String substring = "";
        int[] cnt1 = new int[256];
        int[] cnt2 = new int[256];
        for(int i=0; i<m; i++) {
            cnt1[t.charAt(i)]++;
        }
        while(r < n && l <= r) {
            cnt2[s.charAt(r)]++;
            while(valid(cnt1, cnt2)) {
                if(length >= r-l+1) {
                    length = r-l+1;
                    substring = s.substring(l, r+1);
                } 
                cnt2[s.charAt(l)]--;
                l++;
            }
            r++;
        }
        return substring;
    }

    private boolean valid(int[] cnt1, int[] cnt2) {
        for(int i=0; i<256; i++) {
            if (cnt1[i] > cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}
