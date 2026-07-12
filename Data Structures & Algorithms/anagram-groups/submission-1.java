class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // We will use a HashMap where:
        // Key   -> sorted version of the string
        // Value -> list of all strings that have the same sorted form (anagrams)

        // Example:
        // "eat" -> "aet"
        // "tea" -> "aet"
        // Since both have the same sorted string, they belong to the same group.

        // For every string:
        // 1. Sort its characters.
        // 2. Use the sorted string as the key.
        // 3. If the key already exists, add the current string to its list.
        //    Otherwise, create a new list and add the string.

        // Finally, iterate through the map values and add each list of anagrams
        // to the result.

        List<List<String>> anagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i=0; i<n; i++) {
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if(map.containsKey(sorted)) {
                List<String> angList = map.get(sorted);
                angList.add(s);
                map.put(sorted, angList);
            } else {
                List<String> angList = new ArrayList<>();
                angList.add(s);
                map.put(sorted, angList);
            }
        }

        for(List<String> value: map.values()) {
            anagrams.add(value);
        }
        return anagrams;
    }
}
