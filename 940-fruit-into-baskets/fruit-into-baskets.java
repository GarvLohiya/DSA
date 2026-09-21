class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp= new HashMap<>();
        int low=0;
        int high=0;
        int res=0;
        while(high<fruits.length){
            int x= fruits[high];
            mp.put(x,mp.getOrDefault(x,0)+1);
            while(mp.size()>2){
                int y=fruits[low];
                mp.put(y,mp.get(y)-1);
                if(mp.get(y)==0){
                    mp.remove(y);
                }
                low++;
            }
            if(mp.size()==2){
                
            }
            res=Math.max(res,high-low+1);
            high++;
        }
        return res;
        
    }
}