class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            HashMap<Character,Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            if (!groups.containsKey(freq)) {
                groups.put(freq, new ArrayList<>());
            }
            groups.get(freq).add(s);
            
        }
        return new ArrayList<>(groups.values());
    }
}



