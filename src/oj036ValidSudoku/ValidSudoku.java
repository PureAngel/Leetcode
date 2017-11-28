package oj036ValidSudoku;

import java.util.HashSet;


/**
 * Determine if a Sudoku is valid
 * 
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 * 
 * @author Xueying Bai
 *
 */

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++) {
			HashSet<Character> rowSet = new HashSet<>();
			HashSet<Character> columnSet = new HashSet<>();
			HashSet<Character> cubeSet = new HashSet<>();
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.' && !rowSet.add(board[i][j])) {
					return false;
				}
				if(board[j][i] != '.' && !columnSet.add(board[j][i])) {
					return false;
				}
				int rowIndex = i / 3 * 3;
				int columnIndex = i % 3 * 3;
				if(board[rowIndex + j / 3][columnIndex + j % 3] != '.' 
						&& !cubeSet.add(board[rowIndex + j / 3][columnIndex + j % 3])) {
					return false;
				}
			}
		}
		return true;
	}

}
