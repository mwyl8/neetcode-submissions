class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
        HashMap<String, HashSet<Integer>> boxMap = new HashMap<>();

        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if (board[a][b] == '.') continue;
                int val = Character.getNumericValue(board[a][b]);
                String boxKey = (a / 3) + "," + (b / 3);

                // Check and update row
                rowMap.putIfAbsent(a, new HashSet<>());
                if (!rowMap.get(a).add(val)) return false;

                // Check and update col
                colMap.putIfAbsent(b, new HashSet<>());
                if (!colMap.get(b).add(val)) return false;

                // Check and update box
                boxMap.putIfAbsent(boxKey, new HashSet<>());
                if (!boxMap.get(boxKey).add(val)) return false;
            }
        }
        return true;
    }
}