class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            list.add(new Pair<>(timestamp, value));
            map.put(key, list);

        } else {
            List<Pair<Integer, String>> list = new ArrayList<>();
            list.add(new Pair<>(timestamp, value));
            map.put(key, list);
            
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            int n = map.get(key).size();
            List<Pair<Integer, String>> list = map.get(key);
            int low = 0, high = n-1;
            String result = "";
            while(low <= high) {
                int mid = (low + high)/2;
                Integer time = list.get(mid).getKey();
                if(time == timestamp) {
                    return list.get(mid).getValue();
                } else if(time < timestamp) {
                    result = list.get(mid).getValue();
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return result;
        } else {
            return "";
        }
    }
}
