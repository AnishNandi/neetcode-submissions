class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;

        for (int pile:piles){
            high=Math.max(high,pile);
        }
        int answer=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            long hours=calculateHours(mid,piles);
            if(hours<=h){
                answer=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return answer;
    }

    private long calculateHours(int mid,int piles[]){
        int hours=0;
        for(int pile:piles){
            hours+=Math.ceil((double)pile/mid);
        }
        return hours;
    }
}
