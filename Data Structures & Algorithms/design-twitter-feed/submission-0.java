class Twitter {

    public static class Tweet{
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time){
            this.tweetId=tweetId;
            this.time = time;
        }
    }
    private int timeStamp;
    private Map<Integer,Set<Integer>> following;
    private Map<Integer,Tweet> tweets;
    public Twitter() {
        timeStamp = 0;
        following = new HashMap<>();
        tweets = new HashMap<>();
    }  
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        Tweet newTweet = new Tweet(tweetId,timeStamp);
        newTweet.next = tweets.get(userId);
        tweets.put(userId,newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a,b)-> Integer.compare(b.time,a.time));
        if(tweets.containsKey(userId)){
            maxHeap.offer(tweets.get(userId));
        }

        Set<Integer> followees = following.getOrDefault(userId,Collections.emptySet());

        for(int followeeId: followees){
            Tweet latestTweet = tweets.get(followeeId);
            if(latestTweet != null){
                maxHeap.offer(latestTweet);
            }
        }

        while(!maxHeap.isEmpty() && result.size()<10){
            Tweet current = maxHeap.poll();
            result.add(current.tweetId);

            if(current.next != null){
                maxHeap.offer(current.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId,k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = following.get(followerId);
        if(followees != null){
            followees.remove(followeeId);
        }
    }
}
