class Twitter {

    private Map<Integer, List<Pair<Integer, Integer>>> userTweets;
    private Map<Integer, List<Integer>> followees;
    private Integer time;

    public Twitter() {
        this.userTweets = new HashMap<>();
        this.followees = new HashMap<>();
        this.time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;

        List<Pair<Integer, Integer>> list;

        if (userTweets.containsKey(userId)) {
            list = userTweets.get(userId);
        } else {
            list = new ArrayList<>();
        }

        list.add(new Pair<>(tweetId, time));
        userTweets.put(userId, list);
    }

    public List<Integer> getNewsFeed(int userId) {

        Map<Integer, Integer> temp = new HashMap<>();

        List<Pair<Integer, Integer>> usert = userTweets.get(userId);

        if (usert != null) {
            for (Pair<Integer, Integer> p : usert) {
                temp.put(p.getValue(), p.getKey());
            }
        }

        List<Integer> followeeList = followees.get(userId);

        if (followeeList != null) {
            for (Integer followeeId : followeeList) {

                List<Pair<Integer, Integer>> userts = userTweets.get(followeeId);

                if (userts != null) {
                    for (Pair<Integer, Integer> p : userts) {
                        temp.put(p.getValue(), p.getKey());
                    }
                }
            }
        }

        return temp.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .limit(10)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {

        List<Integer> followList;

        if (followees.containsKey(followerId)) {
            followList = followees.get(followerId);
        } else {
            followList = new ArrayList<>();
        }
        if(!followList.contains(followeeId)) {
            followList.add(followeeId); 
        }
        followees.put(followerId, followList);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followees.containsKey(followerId)) {
            List<Integer> followList = followees.get(followerId);
            followList.remove(Integer.valueOf(followeeId));
            followees.put(followerId, followList);
        }
    }
}