class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int low = 0;

        for (int high = 0; high < s2.length(); high++) {

            char c = s2.charAt(high);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (high - low + 1 > s1.length()) {

                char ch = s2.charAt(low);

                window.put(ch, window.get(ch) - 1);

                if (window.get(ch) == 0) {
                    window.remove(ch);
                }

                low++;
            }
            if (window.equals(need)) {
                return true;
            }
        }

        return false;
    }
}