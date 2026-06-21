class Solution {
    public int characterReplacement(String s, int k) {
        // BF -  generate substrings - O(N^2)
        // create a Map with Key as character and value 
        // if maxValue in map - the length we have covered till now it > K , the that is not valid one 

        // int n = s.length(), length=0;
        // for(int i=0; i<n; i++) {
        //     Map<Character, Integer> map = new HashMap<>();
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        //     for(int j=i+1; j<n; j++) {
        //         map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
        //         int maxValueKey = Collections.max(map.values());
        //         if((j-i+1) - maxValueKey  > k) {
        //             break;
        //         } 
        //         length = Math.max(length, j-i+1);
        //     }
        // }
        // return length;

        // Optimal - O(N) -  sliding window
        int n = s.length(), length=0;
        int l = 0, r=0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<n && l<=r) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            int maxOccurence = Collections.max(map.values());
            if((r-l+1) - maxOccurence > k) {
                // not a valid window 
                // we have to remove characters from map 
                if(map.get(s.charAt(l)) == 1) {
                    map.remove(s.charAt(l));
                } else {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                }
                l++;
            }
            else {
                length = Math.max(length, r-l+1);
            }
            r++;
        }
        return length;
    }
}
