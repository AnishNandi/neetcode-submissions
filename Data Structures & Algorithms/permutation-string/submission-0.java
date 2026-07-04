class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(m>n){
            return false;
        }
        int freq1[]=new int[26];
        int window[]=new int[26];
        for(char ch:s1.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(int i=0;i<m;i++){
            window[s2.charAt(i)-'a']++;
        }
        if(isEqual(freq1,window)){
            return true;
        }
        for(int j=m;j<n;j++){
            window[s2.charAt(j)-'a']++;
            window[s2.charAt(j-m)-'a']--;
            if(isEqual(freq1,window)){
                return true;
            }
        }
        return false;

    }
    private boolean isEqual(int []a,int b[]){
        for(int i=1;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

}
