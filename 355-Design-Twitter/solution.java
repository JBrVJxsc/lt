public class Twitter {

    Map<Integer, Set<Integer>> follow = new HashMap<>();
    Map<Integer, Timeline> timelines = new HashMap<>();
    int time = 0;
    
    class Tweet {
        int time = -1;
        int id = -1;
        
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    
    class Timeline {
        List<Tweet> list = new ArrayList<>();
        int pointer = -1;
        
        void add(Tweet tweet) {
            list.add(tweet);
        }
        
        int getCurrent() {
            return list.get(pointer).id;
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (timelines.get(userId) == null) {
            timelines.put(userId, new Timeline());
        }
        timelines.get(userId).add(new Tweet(tweetId, time++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Timeline> queue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.list.get(b.pointer).time, a.list.get(a.pointer).time);
        });
        
        Set<Integer> friends = follow.get(userId);
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(userId);
        for (int i : friends) {
            Timeline timeline = timelines.get(i);
            if (timeline != null && timeline.list.size() > 0) {
                timeline.pointer = timeline.list.size() - 1; 
                queue.add(timeline);
            }            
        }
        
        List<Integer> list = new ArrayList<>();
        while (list.size() < 10 && !queue.isEmpty()) {
            Timeline timeline = queue.remove();
            list.add(timeline.getCurrent());
            timeline.pointer--;
            if (timeline.pointer >= 0) {
                queue.add(timeline);
            }
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int from, int to) {
        if (follow.get(from) == null) {
            follow.put(from, new HashSet<>());
        }
        follow.get(from).add(to);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int from, int to) {
        if (follow.get(from) == null) {
            return;
        }
        follow.get(from).remove(to);        
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