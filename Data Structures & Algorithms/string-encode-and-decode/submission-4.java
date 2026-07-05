class Solution {

    public String encode(List<String> strs) {
        StringBuffer buffer = new StringBuffer();
        for (String str : strs) {
            int len = str.length();
            if (len < 10) {
                buffer.append('a');
            } else if (len < 100) {
                buffer.append('b');
            } else {
                buffer.append('c');
            }
            buffer.append(len);
            buffer.append(str);
        }
        return buffer.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int numDigits = str.charAt(i) == 'a' ? 1 : str.charAt(i) == 'b' ? 2 : 3;
            int len = 0;
            for (int j = i + 1; j <= i + numDigits; j++) {
                len = len * 10 + Character.getNumericValue(str.charAt(j));
            }
            list.add(str.substring(i + 1 + numDigits, i + 1 + numDigits + len));
            i += 1 + numDigits + len;
        }
        return list;
    }
}