package dsa_java.neetcode.array_and_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
            {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
            {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
            {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku2(board));
    }

    //Solution 1: Brute force
    public static boolean isValidSudoku1(char[][] board) {
        HashMap<Integer, HashSet<Character>> mapRow = new HashMap<>();
        HashMap<Integer, HashSet<Character>> mapCol = new HashMap<>();
        HashMap<Integer, HashSet<Character>> mapBlock = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!mapRow.containsKey(i)) {
                    mapRow.put(i, new HashSet<>());
                }
                HashSet<Character> setRow = mapRow.get(i);

                if (!mapCol.containsKey(j)) {
                    mapCol.put(j, new HashSet<>());
                }
                HashSet<Character> setCol = mapCol.get(j);
                
                int block = findBlock(i, j);
                if (!mapBlock.containsKey(block)) {
                    mapBlock.put(block, new HashSet<>());
                }

                HashSet<Character> setBlock = mapBlock.get(block);

                if (!setRow.contains(board[i][j]) 
                    && !setCol.contains(board[i][j])
                    && !setBlock.contains(board[i][j])) {
                    setRow.add(board[i][j]);
                    setCol.add(board[i][j]);
                    setBlock.add(board[i][j]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    //Solution 2: Improvement
    public static boolean isValidSudoku2(char[][] board) {
        boolean[][] boolRow = new boolean[9][9];
        boolean[][] boolCol = new boolean[9][9];
        boolean[][] boolBlock = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int valueOfChar = board[i][j] - '0' - 1;

                int numOfBlock = findBlock(i, j);

                // Check if value is existed in Col: boolCol[i][valueOfChar]
                // Check if value is existed in Row: boolRow[j][valueOfChar]
                // Check if value is existed in Block: boolBlock[numOfBlock][valueOfChar]
                if ((boolCol[i][valueOfChar] == true) 
                    || boolRow[j][valueOfChar] == true
                    || boolBlock[numOfBlock][valueOfChar] == true) {
                    return false;
                }

                boolCol[i][valueOfChar] = true;
                boolRow[j][valueOfChar] = true;
                boolBlock[numOfBlock][valueOfChar] = true;
            }
        }

        return true;
    }

    //Helper method
    private static int findBlock(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}
