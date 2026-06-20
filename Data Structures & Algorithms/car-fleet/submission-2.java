class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(Arrays.asList(position[i], speed[i]));
        }
        list.sort((a,b) -> Integer.compare(b.get(0), a.get(0)));
        double tar = target;
        Stack<Double> st = new Stack<>();
        for(int i=0; i<n; i++) {
            double time =  (tar - list.get(i).get(0)) / list.get(i).get(1);
            if(st.isEmpty()) {
                st.push(time);
            } else if(!(st.peek() >= time)) {
                st.push(time);
            } 
        }
        return st.size();
    }
}
