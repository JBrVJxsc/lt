public class Twitter {

    private Map<Integer, Set<Integer>> map  = new HashMap<>();
    private List<Integer[]> tweets = new ArrayList<>();
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Integer[]{userId, tweetId});
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0; i--) {
            Integer[] tweet = tweets.get(i);
            if (tweet[0] == userId || map.get(userId) != null && map.get(userId).contains(tweet[0])) {
                list.add(tweet[1]);
                if (list.size() == 10) {
                    return list;
                }
            }
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (map.get(followerId) == null) {
            map.put(followerId, new HashSet<>());
        }
        map.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (map.get(followerId) != null) {
            map.get(followerId).remove(followeeId);  
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */