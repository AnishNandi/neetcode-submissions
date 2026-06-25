class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        if(nums.length==0){
            return 0;
        }
        for(int num:nums){
            set.add(num);
        }
        int maxCount=1;
        for(int n:set){
            if(!set.contains(n-1)){
                int count=1;
                while(set.contains(n+1)){
                    count++;
                    n++;
                }
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}
