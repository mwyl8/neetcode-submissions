class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        for (int a = 0; a < strs.length; a++) {
            char[] chars = new char[strs[a].length()];
            for (int b = 0; b < strs[a].length(); b++) {
                chars[b] = strs[a].charAt(b);
            }
            Arrays.sort(chars);
            String temp = new String(chars);
            if (map.containsKey(temp)) {
                ArrayList<Integer> indices = map.get(temp);
                indices.add(a);
                map.put(temp, indices);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(a);
                map.put(temp, indices);
                keys.add(temp);
            }
        }
        for (int c = 0; c < keys.size(); c++) {
            ArrayList<String> strList = new ArrayList<>();
            for (int d = 0; d < map.get(keys.get(c)).size(); d++) {
                strList.add(strs[map.get(keys.get(c)).get(d)]);
            }
            anagrams.add(strList);
        }
        return anagrams;
    }
}
