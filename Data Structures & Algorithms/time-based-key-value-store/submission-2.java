class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if map already cotains key , create a new pait with vlaue and timestamp and add it to the list 
        if(map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            list.add(new Pair<>(timestamp, value));
            map.put(key, list);
        } 
        // if no key exist , create a new list , add the pair and add the list to map 
        else {
            List<Pair<Integer, String>> list = new ArrayList<>();
            list.add(new Pair<>(timestamp, value));
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        // to do get in o(logn) , we have to think abt binary search 
        // we will do binary search on list to find correct timestamp value , as timestamp values get stored in increasing order , so when we add an item to list they gets stored in increasing timestamo order. 
        String result = "";
        if(map.containsKey(key)) {
            
            List<Pair<Integer, String>> list = map.get(key);
            
            // as we know our value lies in list we will try to find it from list either by moving left or right 
            // we will find mid and check if mid is having targeted time stamp , if so return 
            // else based on targeted timestamp and mid timestamp value we will either move low or high 
            int low = 0;
            int high = list.size()-1;
            while(low <= high) {
                int mid = (low+high)/2;
                // if the pair present in mid index of list having timestamp equal to targeted timestamp , then return it value 
                Integer currentTimestamp = list.get(mid).getKey();
                String currentValue = list.get(mid).getValue();
                if(currentTimestamp == timestamp) {
                    return currentValue;
                } 

                // if timestamp in current pair which is at mid index it <= targeted timestamp , we will store its value as result and try to find if any greater time stamp exist by moving low to mid+1; 
                else if(currentTimestamp < timestamp) {
                    result = currentValue;
                    low = mid+1;
                } 
                // if value is greater than target move to mid-1 
                else {
                    high = mid-1;
                }
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */