class Solution {
    public int lengthOfLongestSubstring(String s) {
        // BF - is generate all substring check if duplicate character are there 
        // if not present , consider the substring and update the length
        int n = s.length();
        // optimal
        // we will consider a window from l -> r , if valid 
        // if not valid move l pointer to remove 
        Set<Character> set = new HashSet<>();
        int lengthOfLongestSubstring = 0;
        int l = 0, r = 0;
        while(l <= r && r < n) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, r-l+1);
            r++;
        }
        return lengthOfLongestSubstring;
    }
}
