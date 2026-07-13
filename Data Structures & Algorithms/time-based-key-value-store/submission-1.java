class TimeMap {
    class Pair{
            int timestamp;
            String value;

        Pair(int timestamp,String value){
            this.timestamp=timestamp;
            this.value=value;
        }
    }

    private Map<String,List<Pair>> map;

    public TimeMap() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);

        int low=0;
        int high= list.size() -1;

        while(low<=high){
            int mid=low +(high-low)/2;

            if(list.get(mid).timestamp <= timestamp){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        if (high < 0) {
            return "";
        }

        return list.get(high).value;
    }
}
