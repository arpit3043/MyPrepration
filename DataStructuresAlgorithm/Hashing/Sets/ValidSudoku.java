package Hashing.Sets;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
    	char[][] board = {
    		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
    		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
    		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
    		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
    		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
    		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
    		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
    		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
    		{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    	};
	    System.out.println(isValidSudoku(board));
        System.out.println(isValidSudokuBitMasking(board));
    }

    // bitmasking code
    private static boolean isValidSudokuBitMasking(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int r = 0; r <= 1<<3; r++) {
            for (int c = 0; c <= 1<<3; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '1';

                if ((rows[r] & (1 << val)) > 0 
                || (cols[c] & (1 << val)) > 0 
                || (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0) {
                    return false;
                }

                rows[r] = rows[r] | (1 << val);
                cols[c] = cols[c] |(1 << val);
                squares[(r / 3) * 3 + (c / 3)] = squares[(r / 3) * 3 + (c / 3)] | (1 << val);
            }
        }
        return true;
    }
    
    private static boolean isValidSudoku(char[][] board) {
    	for(int i=0; i<9; i++) {
    		if(!isValidRow(board, i)) {
    			return false;
    		}
    	}
    	for(int i=0; i<9; i++) {
    		if(!isValidCol(board, i)) {
    			return false;
    		}
    	}
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<3; j++) {
    			if(!isValidBox(board, 3*i, 3*j)) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private static boolean isValidRow(char[][] board, int row) {
    	Set<Character> set = new HashSet<>();
    	for(int i=0; i<9; i++) {
    		if(board[row][i]!='.') {
    			if (set.contains(board[row][i])) {
    				return false;
    			}
    			set.add(board[row][i]);
    		}
    	}
    	return true;
    }
    
    private static boolean isValidCol(char[][] board, int col) {
    	Set<Character>set = new HashSet<>();
    	for(int i=0; i<9; i++) {
    		if(board[i][col]!='.') {
    			if (set.contains(board[i][col])) {
    				return false;
    			}
    			set.add(board[i][col]);
    		}
    	}
    	return true;
    }
    
    private static boolean isValidBox(char[][] board, int row, int col) {
    	Set<Character>set = new HashSet<>();
    	for(int i=row; i<row+3; i++) {
    		for(int j=col; j<col+3; j++) {
    			if (board[i][j]!='.') {
    				if (set.contains(board[i][j])) {
    					return false;
    				}
    				set.add(board[i][j]);
    			}
    		}
    	}
    	return true;
    }
}
