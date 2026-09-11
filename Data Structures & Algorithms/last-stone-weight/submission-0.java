class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int p= pq.poll();
            int q=pq.poll();
            if(p!=q){
                pq.offer(p-q);
            }
        }
        

        if(pq.size()==0){
            return 0;
        }
        else{
            return pq.poll();
        }
    }
}
