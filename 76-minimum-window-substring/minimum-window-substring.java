class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> win= new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int l=0;
        int count=0;
        int len=Integer.MAX_VALUE;
        int start=0;
        for(int r=0; r<=s.length()-1;r++){
            char c= s.charAt(r);
            win.put(c,win.getOrDefault(c,0)+1);
            if(need.containsKey(c)&& win.get(c)<= need.get(c)){
                count++;
            }
            while(count==t.length()){
                if(len>r-l+1){
                    len=r-l+1;
                    start=l;
                }
                char remove= s.charAt(l);
                win.put(remove,win.get(remove)-1);
                if(need.containsKey(remove)&& win.get(remove)<need.get(remove)){
                    count--;
                }
                l++;
            }
        }
        if(len== Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+len);
    }
}