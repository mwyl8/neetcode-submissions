class Solution {
    public boolean isPalindrome(String s) {
        String result = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int i = 0, j = result.length() - 1;
        while (i < j) {
            if (result.charAt(i) != result.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}