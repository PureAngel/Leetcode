package oj051NQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 * @author Xueying Bai
 *
 */

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		board[i][j] = '.';
        	}
        }
        dfs(board, 0, result);
        return result;
    }
    
    private void dfs(char[][] board, int col, List<List<String>> list) {
    	if(col == board.length) {
    		list.add(constructList(board));
    		return;
    	}
    	for(int i = 0; i < board.length; i++) {
    		if(isValid(board, i, col)) {
    			board[i][col] = 'Q';
    			dfs(board, col + 1, list);
    			board[i][col] = '.';
    		}
    	}
    }
    
    private List<String> constructList(char[][] board) {
    	List<String> s = new LinkedList<>();
    	for(int i = 0; i < board.length; i++) {
    		s.add(new String(board[i]));
    	}
    	return s;
    }
    
    private boolean isValid(char[][] board, int x, int y) {
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < y; j++) {
    			if(board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

}
