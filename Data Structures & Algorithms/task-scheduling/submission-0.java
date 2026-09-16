class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(int task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count : freq){
            if(count > 0){
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()){
            time++;
            if(!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time){
                int[] task = cooldownQueue.poll();
                maxHeap.offer(task[0]);
            }

            if(!maxHeap.isEmpty()){
                int remaining = maxHeap.poll();
                remaining--;
                if(remaining > 0){
                    cooldownQueue.offer(new int[] {remaining,time+n+1});
                }
            }

            
            
        }

        return time;    
    }
}
