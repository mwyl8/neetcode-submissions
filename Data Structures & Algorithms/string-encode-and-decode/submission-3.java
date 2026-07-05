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
        while (!str.equals("")) {
            int numDigits = str.charAt(0) == 'a' ? 1 : str.charAt(0) == 'b' ? 2 : 3;
            int len = 0;
            for (int i = 1; i <= numDigits; i++) {
                len = len * 10 + Character.getNumericValue(str.charAt(i));
            }
            list.add(str.substring(1 + numDigits, 1 + numDigits + len));
            str = str.substring(1 + numDigits + len);
        }
        return list;
    }
}