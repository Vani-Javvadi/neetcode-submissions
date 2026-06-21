class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // BF - sort s1 
        // go through s2 , find substrings of s2 , sort substring check if s1 == s2 then return true 
        // TC - O(N^2)

        // optimal 
        // we will traverse the string by putting l = 0, r=0, 
        // when we get a character which is not part of s1 , then there is not point in considering the substr from l -> r 
        // so we will move our l, i.e, l = r 
        // in other case like when we find the character is part of s1 , we will try to check if current window is permutation of s1 
        // to check valid or not we will use cnt array 

        int n = s1.length();
        int m = s2.length();
        int[] cnt1 = new int[26];
        for(int i=0; i<n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
        } 
        int l=0, r=0;
        int[] cnt2 = new int[26];
        while(r<m && l<=r) {
            // we will move from window if current character is not even part of perm 
            // mean s2 character not present in s1 
            cnt2[s2.charAt(r) - 'a']++;
            while(cnt1[s2.charAt(r) - 'a'] < cnt2[s2.charAt(r) - 'a']) {
                cnt2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(valid(cnt1, cnt2)) {
                return true;
            }
            r++;

            // if(cnt1[s2.charAt(r) - 'a'] == 0) {
            //     while(l <= r) {
            //         if(cnt2[s2.charAt(l) - 'a'] != 0) {
            //             cnt2[s2.charAt(l) - 'a']--;
            //         }   
            //         l++;
            //     }
            // }  
            
            // else {
                
            //     if(valid(cnt1, cnt2)) {
            //         return true;
            //     }
            //      // character occurence is more, move l until it is equal to s1 occurence 
                
            // }
        }   
        return false;    
    }

    private boolean valid(int[] cnt1, int[] cnt2) {
        //  System.out.println("In Valid Method");
        for(int i=0; i<26; i++) {
            // System.out.println("Counts " + cnt1[i] + " " + cnt2[i]);
            if(cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
        
    }
}
