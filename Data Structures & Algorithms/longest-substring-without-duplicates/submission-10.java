class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res = 1;
        int first = 0;
        int last = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(first), first);
        while (last < s.length()) {
            if (map.containsKey(s.charAt(last))) {
                if (map.get(s.charAt(last)) + 1 > first) {
                    if (map.get(s.charAt(last)) >= first) {
                        first = map.get(s.charAt(last)) + 1;
                    }
                }
            } 
            res = Math.max(last - first + 1, res);
            map.put(s.charAt(last), last);
            last++;
        }  
        return res;
    }
}
