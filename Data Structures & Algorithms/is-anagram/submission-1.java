class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> list = new ArrayList<>();
        for (int a = 0; a < s.length(); a++) {
            list.add(s.charAt(a));
        }
        for (int b = 0; b < t.length(); b++) {
            if (list.contains(t.charAt(b))) list.remove((Character) t.charAt(b));
            else return false;
        }
        if (list.size() != 0) return false;
        return true;
    }
}
