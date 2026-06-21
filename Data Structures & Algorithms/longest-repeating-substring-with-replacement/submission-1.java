class Solution {
    public int characterReplacement(String s, int k) {
        // BF -  generate substrings 
        // create a Map with Key as character and value 
        // if maxValue in map - the length we have covered till now it > K , the that is not valid one 

        int n = s.length(), length=0;
        for(int i=0; i<n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            for(int j=i+1; j<n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                int maxValueKey = Collections.max(map.values());
                if((j-i+1) - maxValueKey  > k) {
                    break;
                } 
                length = Math.max(length, j-i+1);
            }
        }
        return length;
    }
}
