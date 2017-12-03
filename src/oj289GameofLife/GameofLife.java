package oj289GameofLife;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * 1.Could you solve it in-place? 
 * Remember that the board needs to be updated at the same time: 
 * You cannot update some cells first and then use their updated values to update other cells.
 * 
 * 2.In this question, we represent the board using a 2D array. 
 * In principle, the board is infinite, 
 * which would cause problems when the active area encroaches the border of the array. 
 * How would you address these problems?
 * 
 * @author Xueying Bai
 *
 */

public class GameofLife {
	public void gameOfLife(int[][] board) {
		/**
		 * use 2 bits to represent the next & the current state:
		 * 00: dead, dead(next, current)
		 * 01: dead, live
		 * 10: live, dead
		 * 11: live, live
		 * 
		 * at the beginning: each is 00 or 01
		 * in the end: delete 1st by >> 1
		 * 01 -> 11: board == 1 && (lives == 2 || lives == 3)
		 * 00 -> 10: board == 0 && lives == 3
		 * 
		 * get current state: board[i][j] & 1
		 * get next state: board[i][j] >> 1
		 */
		if(board == null || board.length == 0) return;
		int row = board.length, col = board[0].length;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int lives = countLives(board, row, col, i, j);
				
				if(board[i][j] == 1 && (lives == 2 || lives == 3)) {
					board[i][j] = 3;
				}
				if(board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] >>= 1;
			}
		}
	}
	
	private int countLives(int[][] board, int row, int col, int i, int j) {
		int lives = 0;
		for(int x = Math.max(0, i - 1); x <= Math.min(row - 1, i + 1); x++) {
			for(int y = Math.max(0, j - 1); y <= Math.min(col - 1, j + 1); y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}

}
