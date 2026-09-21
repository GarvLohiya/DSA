class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        int high=0;
        int res=0;
        HashMap<Character, Integer> mp= new HashMap<>();
        while(high<s.length()){
            char c= s.charAt(high);
            mp.put(c,mp.getOrDefault(c,0)+1);
            while(mp.get(c)>1){
                char ch= s.charAt(low);
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0){
                    mp.remove(ch);
                }
                low++;
               
            }
            res=Math.max(res,high-low+1);
            high++;
        }
        return res;
    }
}