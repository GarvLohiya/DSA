class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp= new HashMap<>();
        int n=s.length();
        int low=0;
        int high=0;
        int res=0;
        int maxf=0;
        while(high<n){
            char c=s.charAt(high);
            mp.put(c,mp.getOrDefault(c,0)+1);
            maxf=Math.max(maxf, mp.get(c));
            while((high-low+1)-maxf>k){
                char ch=s.charAt(low);
                mp.put(ch,mp.get(ch)-1);
                low++;
            }
            res=Math.max(res,(high-low+1));
            high++;
        }
        return res;

    }
}